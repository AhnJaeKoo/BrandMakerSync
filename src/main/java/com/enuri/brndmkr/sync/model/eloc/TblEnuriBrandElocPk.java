package com.enuri.brndmkr.sync.model.eloc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor // 생성자 자동 생성
@Setter
@Getter
@Embeddable
public class TblEnuriBrandElocPk implements Serializable {

	private static final long serialVersionUID = 1L;

	private int brandId;
	private int makerId;
}
