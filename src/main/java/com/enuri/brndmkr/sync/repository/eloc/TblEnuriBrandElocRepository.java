package com.enuri.brndmkr.sync.repository.eloc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.enuri.brndmkr.sync.model.eloc.TblEnuriBrandEloc;
import com.enuri.brndmkr.sync.model.eloc.TblEnuriBrandElocPk;

@Repository
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public interface TblEnuriBrandElocRepository extends JpaRepository<TblEnuriBrandEloc, TblEnuriBrandElocPk> {
}
