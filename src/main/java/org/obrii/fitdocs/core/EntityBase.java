package org.obrii.fitdocs.core;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public abstract class EntityBase<TId extends Serializable> {

    @Id
    @GeneratedValue
    private TId id;

    public EntityBase(TId id) {
        this.id = id;
    }

    public EntityBase() {
        this.id = null;
    }
}