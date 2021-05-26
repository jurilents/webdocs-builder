package org.obrii.fitdocs.core;

//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
//import org.hibernate.annotations.TypeDef;
//import org.hibernate.annotations.TypeDefs;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
//@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
@EntityListeners(AuditingEntityListener.class)
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