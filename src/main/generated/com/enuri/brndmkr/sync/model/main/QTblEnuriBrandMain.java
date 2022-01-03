package com.enuri.brndmkr.sync.model.main;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTblEnuriBrandMain is a Querydsl query type for TblEnuriBrandMain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTblEnuriBrandMain extends EntityPathBase<TblEnuriBrandMain> {

    private static final long serialVersionUID = 1430366342L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTblEnuriBrandMain tblEnuriBrandMain = new QTblEnuriBrandMain("tblEnuriBrandMain");

    public final StringPath brandNm = createString("brandNm");

    public final StringPath brandNmNew = createString("brandNmNew");

    public final StringPath delYn = createString("delYn");

    public final QTblEnuriBrandMainPk id;

    public final DateTimePath<java.sql.Timestamp> insDate = createDateTime("insDate", java.sql.Timestamp.class);

    public final StringPath insOprt = createString("insOprt");

    public final DateTimePath<java.sql.Timestamp> updDate = createDateTime("updDate", java.sql.Timestamp.class);

    public final StringPath updOrpt = createString("updOrpt");

    public QTblEnuriBrandMain(String variable) {
        this(TblEnuriBrandMain.class, forVariable(variable), INITS);
    }

    public QTblEnuriBrandMain(Path<? extends TblEnuriBrandMain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTblEnuriBrandMain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTblEnuriBrandMain(PathMetadata metadata, PathInits inits) {
        this(TblEnuriBrandMain.class, metadata, inits);
    }

    public QTblEnuriBrandMain(Class<? extends TblEnuriBrandMain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QTblEnuriBrandMainPk(forProperty("id")) : null;
    }

}

