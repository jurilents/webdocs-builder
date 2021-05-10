package org.obrii.fitdocs.entity;

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

    @Column(nullable = false, length = 64)
    private String name;

    private Integer position;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    private Template template;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldKey> keys;
}
