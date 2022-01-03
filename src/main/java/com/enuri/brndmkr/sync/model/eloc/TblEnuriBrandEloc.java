package com.enuri.brndmkr.sync.model.eloc;

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
public class TblEnuriBrandEloc implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblEnuriBrandElocPk id;
	private String brandNm;
	private String delYn;
	private Timestamp insDate;
	private String insOprt;
	private Timestamp updDate;
	private String updOprt;
	private String brandNmNew;
}