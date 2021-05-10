package org.obrii.fitdocs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityWithId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends EntityWithId {

    @Column(nullable = false, length = 64)
    private String name;

    private Integer position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentId")
    private Category category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Template> templates;
}
