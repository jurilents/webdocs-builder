package org.obrii.fitdocs.service;

import org.obrii.fitdocs.entities.FieldValue;
import org.obrii.fitdocs.entities.Template;
import org.obrii.fitdocs.entities.User;

public interface DocumentService {

    void createForAnonimousUser(Template template, FieldValue[] values);

    void createForUser(User user);
}
