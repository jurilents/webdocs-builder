package org.obrii.fitdocs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityWithId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Templates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Template extends EntityWithId {

    private String name;
    private String sourceUrl;
    private LocalDateTime creationDate;
    private Short rate;
    private Boolean isRecommended;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_Templates_Categories"))
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_Templates_Users"))
    private Category creator;

    @OneToMany(mappedBy = "Roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldGroup> groups;

    @OneToMany(mappedBy = "FieldKeys", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FieldKey> keys;

    @OneToMany(mappedBy = "Documents", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Document> documents;
}
