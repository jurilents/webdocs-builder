package org.obrii.fitdocs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.obrii.fitdocs.core.EntityWithId;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends EntityWithId {

    private String firstname;
    private String secondname;
    private String middlename;

    private String email;
    private Boolean emailConfirmed;
    private Boolean gender;
    private LocalDate birthday;
    private LocalDateTime registrationDate;
    private String passwordHash;

    @OneToMany(mappedBy = "Roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "Templates", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Template> templates;

    @OneToMany(mappedBy = "Documents", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Document> documents;
}
