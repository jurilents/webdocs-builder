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

    @Column(nullable = false, length = 64)
    private String text;

    private Integer minLength;
    private Integer maxLength;

    @Column(nullable = false)
    private Integer isRequired;

    @Column(nullable = false)
    private Short type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    private Template template;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private FieldGroup group;

    @OneToMany(mappedBy = "key", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FieldValue> values;
}
