package org.obrii.fitdocs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityWithId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FieldKeys")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FieldKey extends EntityWithId {

    private Integer minLength;
    private Integer maxLength;
    private Integer isRequired;
    private Integer type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FieldKeys_Templates"))
    private Template template;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FieldKeys_FieldGroups"))
    private FieldGroup group;

    @OneToMany(mappedBy = "FieldValues", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FieldValue> values;
}
