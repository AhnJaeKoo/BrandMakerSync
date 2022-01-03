package com.enuri.brndmkr.sync.batch.job;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.enuri.brndmkr.sync.mail.SuccessMail;
import com.enuri.brndmkr.sync.model.eloc.TblEnuriBrandEloc;
import com.enuri.brndmkr.sync.model.eloc.TblEnuriMakerEloc;
import com.enuri.brndmkr.sync.model.main.TblEnuriBrandMain;
import com.enuri.brndmkr.sync.model.main.TblEnuriBrandMainPk;
import com.enuri.brndmkr.sync.model.main.TblEnuriMakerMain;
import com.enuri.brndmkr.sync.repository.eloc.TblEnuriBrandElocRepository;
import com.enuri.brndmkr.sync.repository.eloc.TblEnuriMakerElocRepository;
import com.enuri.brndmkr.sync.repository.main.TblEnuriBrandMainRepository;
import com.enuri.brndmkr.sync.repository.main.TblEnuriMakerMainRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BrandSyncJobConfig {

	@Value("${spring.batch.chunk-size}")
	private int chunkSize;

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	@Resource
	private EntityManagerFactory elocEntityManagerFactory;
	@Resource
	private EntityManagerFactory mainEntityManagerFactory;
	@Resource
	private JpaTransactionManager elocTransactionManager;
	@Resource
	private JpaTransactionManager mainTransactionManager;
	@Resource
	private DataSource mainDataSource;

	private final TblEnuriBrandElocRepository tblEnuriBrandElocRepository;
	private final TblEnuriMakerElocRepository tblEnuriMakerElocRepository;
	private final TblEnuriBrandMainRepository tblEnuriBrandMainRepository;
	private final TblEnuriMakerMainRepository tblEnuriMakerMainRepository;
	private final SuccessMail successMail;

	private long preBrandCnt = 0;
	private long postBrandCnt = 0;
	private long preMakerCnt = 0;
	private long postMakerCnt = 0;

	@PersistenceContext(unitName = "main")
	private EntityManager mainEm;

	@Bean
	public Job brandSyncJob() {
		return jobBuilderFactory.get("brandSyncJob")
				.start(getCountAndTruncateStep()) //count 추출 및 truncate table
				.next(brandSyncStep()) 	// 브랜드 동기화
				.next(makerSyncStep())	// 제조사 동기화
				.next(sendEmail()) 		// 이메일 발송
				.build();
	}

	@Bean
	@JobScope
	public Step getCountAndTruncateStep() {
		return stepBuilderFactory.get("getCountAndTruncate").tasklet((contribution, chunkContext) -> {
			preBrandCnt = tblEnuriBrandMainRepository.count();
			preMakerCnt = tblEnuriMakerMainRepository.count();
			tblEnuriBrandMainRepository.truncateTable();
			tblEnuriMakerMainRepository.truncateTable();
			return RepeatStatus.FINISHED;
		}).build();
	}

	@Bean
	@JobScope
	public Step brandSyncStep() {
		return stepBuilderFactory.get("brandSyncStep") // 생성 step 이름
				.<TblEnuriBrandEloc, TblEnuriBrandMain>chunk(chunkSize) //입력타입, 출력타입
				.reader(brandSyncStepItemReader())
				.processor(brandSyncItemProcessor())
				.writer(brandSyncStepItemWriter())
				.build();
	}

	@Bean
	@JobScope
	public Step makerSyncStep() {
		return stepBuilderFactory.get("makerSyncStep") // 생성 step 이름
				.<TblEnuriMakerEloc, TblEnuriMakerMain>chunk(chunkSize) //입력타입, 출력타입
				.reader(makerSyncStepItemReader())
				.processor(makerSyncItemProcessor())
				.writer(makerSyncStepItemWriter())
				.build();
	}

	@Bean
	@StepScope
	public RepositoryItemReader<TblEnuriBrandEloc> brandSyncStepItemReader() {
		Map<String, Sort.Direction> sorts = new HashMap<>();
		sorts.put("id.brandId", Sort.Direction.ASC);
		sorts.put("id.makerId", Sort.Direction.ASC);

		int totCnt = (int) tblEnuriBrandElocRepository.count();
		log.info("Brand count = {}", totCnt);

		return new RepositoryItemReaderBuilder<TblEnuriBrandEloc>()
				.name("brandSyncStepItemReader")
				.repository(tblEnuriBrandElocRepository)
				.methodName("findAll")
				.pageSize(chunkSize)
				.maxItemCount(totCnt)
				.sorts(sorts)
				.build();
	}

	@Bean
	@StepScope
	public RepositoryItemReader<TblEnuriMakerEloc> makerSyncStepItemReader() {
		int totCnt = (int) tblEnuriMakerElocRepository.count();
		log.info("Maker count = {}", totCnt);

		return new RepositoryItemReaderBuilder<TblEnuriMakerEloc>()
				.name("makerSyncStepItemReader")
				.repository(tblEnuriMakerElocRepository)
				.methodName("findAll")
				.pageSize(chunkSize)
				.maxItemCount(totCnt)
				.sorts(Collections.singletonMap("makerId", Sort.Direction.ASC))
				.build();
	}

	@Bean
	@StepScope
	public FunctionItemProcessor<TblEnuriBrandEloc, TblEnuriBrandMain> brandSyncItemProcessor() {
		return new FunctionItemProcessor<> (eloc -> {
			TblEnuriBrandMainPk pk = new TblEnuriBrandMainPk(new BigDecimal(eloc.getId().getBrandId()),
					new BigDecimal(eloc.getId().getMakerId()));

			return new TblEnuriBrandMain(pk, eloc.getBrandNm(), eloc.getDelYn(), eloc.getInsDate(), eloc.getInsOprt(),
					eloc.getUpdDate(), eloc.getUpdOprt(), eloc.getBrandNmNew());
		});
	}

	@Bean
	@StepScope
	public FunctionItemProcessor<TblEnuriMakerEloc, TblEnuriMakerMain> makerSyncItemProcessor() {
		return new FunctionItemProcessor<> (eloc ->
			new TblEnuriMakerMain(new BigDecimal(eloc.getMakerId()), eloc.getMakerNm(), eloc.getDelYn(),
					eloc.getInsDate(), eloc.getInsOprt(), eloc.getUpdDate(), eloc.getUpdOprt(), eloc.getMakerNmNew())
		);
	}

	@Bean
	@StepScope
	public JdbcBatchItemWriter<TblEnuriBrandMain> brandSyncStepItemWriter() {
		JdbcBatchItemWriter<TblEnuriBrandMain> itemWriter = new JdbcBatchItemWriterBuilder<TblEnuriBrandMain>()
				.dataSource(mainDataSource)
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()) //entity 자동으로 파라미터로 생성할 수 있는 설정
				.sql("""
						INSERT INTO tbl_enuri_brand
						            (brand_id,
						             maker_id,
						             brand_nm,
						             del_yn,
						             ins_date,
						             ins_oprt,
						             upd_date,
						             upd_orpt,
						             brand_nm_new)
						VALUES     (:id.brandId,
						            :id.makerId,
						            :brandNm,
						            :delYn,
						            :insDate,
						            :insOprt,
						            :updDate,
						            :updOrpt,
						            :brandNmNew)
						""")
				.build();
		itemWriter.afterPropertiesSet();
		return itemWriter;
	}

	@Bean
	@StepScope
	public JdbcBatchItemWriter<TblEnuriMakerMain> makerSyncStepItemWriter() {
		JdbcBatchItemWriter<TblEnuriMakerMain> itemWriter = new JdbcBatchItemWriterBuilder<TblEnuriMakerMain>()
				.dataSource(mainDataSource)
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()) //entity 자동으로 파라미터로 생성할 수 있는 설정
				.sql("""
						INSERT INTO tbl_enuri_maker
						            (maker_id,
						             maker_nm,
						             del_yn,
						             ins_date,
						             ins_oprt,
						             upd_date,
						             upd_oprt,
						             maker_nm_new)
						VALUES     (:makerId,
						            :makerNm,
						            :delYn,
						            :insDate,
						            :insOprt,
						            :updDate,
						            :updOprt,
						            :makerNmNew)
						""")
				.build();
		itemWriter.afterPropertiesSet();
		return itemWriter;
	}

	@Bean
	@JobScope
	public Step sendEmail() {
		return stepBuilderFactory.get("sendEmail").tasklet((contribution, chunkContext) -> {
			postBrandCnt = tblEnuriBrandMainRepository.count();
			postMakerCnt = tblEnuriMakerMainRepository.count();
			successMail.sendMail(getHtml());
			log.info("email Send~!!");
			return RepeatStatus.FINISHED;
		}).build();
	}

	private String getHtml() {
		DecimalFormat formatter = new DecimalFormat("###,###");
		return """
					<table border='1' bordercolor='blue' width ='400' height='200'>
					<tr bgcolor='blue'><td colspan='3' style='color:white' align='center'><b>tbl_enuri_brand</b></td></tr>
					<tr align='center' bgcolor='skybule'><td><b>eloc</b></td><td><b>oracle(As-Is)</b></td><td><b>oracle(To-Be)</b></td></tr>
					<tr align='center'><td> %s 건</td><td> %s 건</td><td> %s 건</td></tr>
					</table>
					<br>
					<table border='1' bordercolor='blue' width ='400' height='200'>
					<tr bgcolor='blue'><td colspan='3' style='color:white' align='center'><b>tbl_enuri_maker</b></td></tr>
					<tr align='center' bgcolor='skybule'><td><b>eloc</b></td><td><b>oracle(As-Is)</b></td><td><b>oracle(To-Be)</b></td></tr>
					<tr align='center'><td> %s 건</td><td> %s 건</td><td> %s 건</td></tr>
					</table>
				"""
				.formatted(formatter.format(postBrandCnt), formatter.format(preBrandCnt),
						formatter.format(postBrandCnt), formatter.format(postMakerCnt),
						formatter.format(preMakerCnt), formatter.format(postMakerCnt));
	}
}