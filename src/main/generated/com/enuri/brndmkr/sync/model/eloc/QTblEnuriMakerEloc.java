package com.enuri.brndmkr.sync.model.eloc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTblEnuriMakerEloc is a Querydsl query type for TblEnuriMakerEloc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTblEnuriMakerEloc extends EntityPathBase<TblEnuriMakerEloc> {

    private static final long serialVersionUID = -1098874809L;

    public static final QTblEnuriMakerEloc tblEnuriMakerEloc = new QTblEnuriMakerEloc("tblEnuriMakerEloc");

    public final StringPath delYn = createString("delYn");

    public final DateTimePath<java.sql.Timestamp> insDate = createDateTime("insDate", java.sql.Timestamp.class);

    public final StringPath insOprt = createString("insOprt");

    public final NumberPath<Integer> makerId = createNumber("makerId", Integer.class);

    public final StringPath makerNm = createString("makerNm");

    public final StringPath makerNmNew = createString("makerNmNew");

    public final DateTimePath<java.sql.Timestamp> updDate = createDateTime("updDate", java.sql.Timestamp.class);

    public final StringPath updOprt = createString("updOprt");

    public QTblEnuriMakerEloc(String variable) {
        super(TblEnuriMakerEloc.class, forVariable(variable));
    }

    public QTblEnuriMakerEloc(Path<? extends TblEnuriMakerEloc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTblEnuriMakerEloc(PathMetadata metadata) {
        super(TblEnuriMakerEloc.class, metadata);
    }

}

