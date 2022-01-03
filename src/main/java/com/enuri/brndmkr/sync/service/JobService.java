package com.enuri.brndmkr.sync.service;

import java.util.LinkedHashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobService {

	private final JobLauncher jobLauncher;
	private final Job brandSyncJob;

	private JobParameters createInitJobParam() {
		var map = new LinkedHashMap<String, JobParameter>();
		map.put("time", new JobParameter(System.currentTimeMillis()));
		return new JobParameters(map);
	}

	public String brandMakerSyncJob() {
		String result = "정상구동~";

		try {
			jobLauncher.run(brandSyncJob, createInitJobParam());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
			log.error("", e);
			result = "처리실패!!";
		}

		return result;
	}

}
