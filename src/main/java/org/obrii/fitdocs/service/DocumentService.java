package org.obrii.fitdocs.service;

import org.obrii.fitdocs.entity.Document;
import org.obrii.fitdocs.entity.FieldValue;
import org.obrii.fitdocs.entity.Template;
import org.obrii.fitdocs.entity.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    Document createForAnonymousUser(Template template, List<FieldValue> values) throws IOException; // TODO implement me

    Document createForUser(User user, Template template, List<FieldValue> values);
}
