package org.obrii.fitdocs.entity;

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

    @Lob
    @Column(nullable = false)
    private String text;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fieldId")
    private FieldKey key;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "documentId")
    private Document document;
}
