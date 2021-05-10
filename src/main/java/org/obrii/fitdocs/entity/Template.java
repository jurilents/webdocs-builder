package org.obrii.fitdocs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityWithId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Templates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Template extends EntityWithId {

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 128)
    private String sourceUrl;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Column(nullable = false)
    private Byte rate;

    @Column(nullable = false)
    private Boolean isRecommended;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "creatorId")
    private Category creator;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldGroup> groups;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldKey> keys;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Document> documents;
}
