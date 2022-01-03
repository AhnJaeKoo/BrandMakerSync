package com.enuri.brndmkr.sync.model.eloc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTblEnuriBrandElocPk is a Querydsl query type for TblEnuriBrandElocPk
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTblEnuriBrandElocPk extends BeanPath<TblEnuriBrandElocPk> {

    private static final long serialVersionUID = -350918235L;

    public static final QTblEnuriBrandElocPk tblEnuriBrandElocPk = new QTblEnuriBrandElocPk("tblEnuriBrandElocPk");

    public final NumberPath<Integer> brandId = createNumber("brandId", Integer.class);

    public final NumberPath<Integer> makerId = createNumber("makerId", Integer.class);

    public QTblEnuriBrandElocPk(String variable) {
        super(TblEnuriBrandElocPk.class, forVariable(variable));
    }

    public QTblEnuriBrandElocPk(Path<? extends TblEnuriBrandElocPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTblEnuriBrandElocPk(PathMetadata metadata) {
        super(TblEnuriBrandElocPk.class, metadata);
    }

}

