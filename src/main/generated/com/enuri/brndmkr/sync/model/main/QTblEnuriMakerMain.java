package com.enuri.brndmkr.sync.model.main;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTblEnuriMakerMain is a Querydsl query type for TblEnuriMakerMain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTblEnuriMakerMain extends EntityPathBase<TblEnuriMakerMain> {

    private static final long serialVersionUID = -794399037L;

    public static final QTblEnuriMakerMain tblEnuriMakerMain = new QTblEnuriMakerMain("tblEnuriMakerMain");

    public final StringPath delYn = createString("delYn");

    public final DateTimePath<java.sql.Timestamp> insDate = createDateTime("insDate", java.sql.Timestamp.class);

    public final StringPath insOprt = createString("insOprt");

    public final NumberPath<java.math.BigDecimal> makerId = createNumber("makerId", java.math.BigDecimal.class);

    public final StringPath makerNm = createString("makerNm");

    public final StringPath makerNnNew = createString("makerNnNew");

    public final DateTimePath<java.sql.Timestamp> updDate = createDateTime("updDate", java.sql.Timestamp.class);

    public final StringPath updOrpt = createString("updOrpt");

    public QTblEnuriMakerMain(String variable) {
        super(TblEnuriMakerMain.class, forVariable(variable));
    }

    public QTblEnuriMakerMain(Path<? extends TblEnuriMakerMain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTblEnuriMakerMain(PathMetadata metadata) {
        super(TblEnuriMakerMain.class, metadata);
    }

}

