package org.obrii.fitdocs.service;

import org.obrii.fitdocs.entity.FieldValue;
import org.obrii.fitdocs.entity.Template;
import org.obrii.fitdocs.entity.User;

public interface DocumentService {

    void createForAnonimousUser(Template template, FieldValue[] values);

    void createForUser(User user);
}
