package com.enuri.brndmkr.sync.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enuri.brndmkr.sync.model.main.TblEnuriBrandMain;
import com.enuri.brndmkr.sync.model.main.TblEnuriBrandMainPk;

@Repository
public interface TblEnuriBrandMainRepository extends JpaRepository<TblEnuriBrandMain, TblEnuriBrandMainPk> {

	@Transactional
	@Modifying
	@Query(value = "TRUNCATE TABLE tbl_enuri_brand", nativeQuery = true)
	public int truncateTable();
}
