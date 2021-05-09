package org.obrii.fitdocs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityBase;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FieldGroups")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FieldGroup extends EntityBase<Integer> {

    private String name;
    private Integer position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FieldGroups_Templates"))
    private Template template;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldKey> keys;
}
