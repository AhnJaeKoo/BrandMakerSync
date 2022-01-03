package com.enuri.brndmkr.sync.repository.main;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enuri.brndmkr.sync.model.main.TblEnuriMakerMain;

@Repository
public interface TblEnuriMakerMainRepository extends JpaRepository<TblEnuriMakerMain, BigDecimal> {

	@Transactional
	@Modifying
	@Query(value = "TRUNCATE TABLE tbl_enuri_maker", nativeQuery = true)
	public int truncateTable();
}
