package com.enuri.brndmkr.sync.model.main;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTblEnuriBrandMainPk is a Querydsl query type for TblEnuriBrandMainPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTblEnuriBrandMainPk extends BeanPath<TblEnuriBrandMainPk> {

    private static final long serialVersionUID = 192522529L;

    public static final QTblEnuriBrandMainPk tblEnuriBrandMainPk = new QTblEnuriBrandMainPk("tblEnuriBrandMainPk");

    public final NumberPath<java.math.BigDecimal> brandId = createNumber("brandId", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> makerId = createNumber("makerId", java.math.BigDecimal.class);

    public QTblEnuriBrandMainPk(String variable) {
        super(TblEnuriBrandMainPk.class, forVariable(variable));
    }

    public QTblEnuriBrandMainPk(Path<? extends TblEnuriBrandMainPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTblEnuriBrandMainPk(PathMetadata metadata) {
        super(TblEnuriBrandMainPk.class, metadata);
    }

}

