package com.enuri.brndmkr.sync.model.eloc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTblEnuriBrandEloc is a Querydsl query type for TblEnuriBrandEloc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTblEnuriBrandEloc extends EntityPathBase<TblEnuriBrandEloc> {

    private static final long serialVersionUID = 1125890570L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTblEnuriBrandEloc tblEnuriBrandEloc = new QTblEnuriBrandEloc("tblEnuriBrandEloc");

    public final StringPath brandNm = createString("brandNm");

    public final StringPath brandNmNew = createString("brandNmNew");

    public final StringPath delYn = createString("delYn");

    public final QTblEnuriBrandElocPk id;

    public final DateTimePath<java.sql.Timestamp> insDate = createDateTime("insDate", java.sql.Timestamp.class);

    public final StringPath insOprt = createString("insOprt");

    public final DateTimePath<java.sql.Timestamp> updDate = createDateTime("updDate", java.sql.Timestamp.class);

    public final StringPath updOprt = createString("updOprt");

    public QTblEnuriBrandEloc(String variable) {
        this(TblEnuriBrandEloc.class, forVariable(variable), INITS);
    }

    public QTblEnuriBrandEloc(Path<? extends TblEnuriBrandEloc> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTblEnuriBrandEloc(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTblEnuriBrandEloc(PathMetadata metadata, PathInits inits) {
        this(TblEnuriBrandEloc.class, metadata, inits);
    }

    public QTblEnuriBrandEloc(Class<? extends TblEnuriBrandEloc> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QTblEnuriBrandElocPk(forProperty("id")) : null;
    }

}

