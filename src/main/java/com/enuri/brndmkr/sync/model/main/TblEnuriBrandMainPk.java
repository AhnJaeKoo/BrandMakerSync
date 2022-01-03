package com.enuri.brndmkr.sync.model.main;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class TblEnuriBrandMainPk implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal brandId;
	private BigDecimal makerId;
}
