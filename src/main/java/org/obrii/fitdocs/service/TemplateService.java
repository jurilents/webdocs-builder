package org.obrii.fitdocs.service;

import org.obrii.fitdocs.dto.TemplateCreateDto;
import org.obrii.fitdocs.entity.Template;

public interface TemplateService {

    Template createTemplate(TemplateCreateDto body);
}
