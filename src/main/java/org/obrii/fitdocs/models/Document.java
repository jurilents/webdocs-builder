package org.obrii.fitdocs.models;

import org.obrii.fitdocs.core.ModelBase;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Document extends ModelBase {
    private String name;

    public Document() { }

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
