package com.enuri.brndmkr.sync.model.main;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tbl_enuri_maker")
@NoArgsConstructor
@AllArgsConstructor
public class TblEnuriMakerMain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal makerId;
	private String makerNm;
	private String delYn;
	private Timestamp insDate;
	private String insOprt;
	private Timestamp updDate;
	private String updOprt;
	private String makerNmNew;
}
