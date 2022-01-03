package com.enuri.brndmkr.sync.model.main;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tbl_enuri_brand")
@NoArgsConstructor
@AllArgsConstructor
public class TblEnuriBrandMain implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblEnuriBrandMainPk id;
	private String brandNm;
	private String delYn;
	private Timestamp insDate;
	private String insOprt;
	private Timestamp updDate;
	private String updOrpt;
	private String brandNmNew;
}