package org.obrii.fitdocs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityWithId;

import javax.persistence.*;

@Entity
@Table(name = "FieldValues")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FieldValue extends EntityWithId {

    private String value;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FiledValues_FieldKeys"))
    private FieldKey key;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FiledValues_Documents"))
    private Document document;
}
