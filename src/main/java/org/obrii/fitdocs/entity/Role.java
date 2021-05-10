package org.obrii.fitdocs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends EntityBase<Short> {

    @Column(nullable = false, length = 32)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
}
