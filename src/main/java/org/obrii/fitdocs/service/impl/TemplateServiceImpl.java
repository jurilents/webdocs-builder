package org.obrii.fitdocs.service.impl;

import org.obrii.fitdocs.dao.TemplateDao;
import org.obrii.fitdocs.dto.TemplateCreateDto;
import org.obrii.fitdocs.dto.TemplateFieldDto;
import org.obrii.fitdocs.entity.FieldGroup;
import org.obrii.fitdocs.entity.FieldKey;
import org.obrii.fitdocs.entity.Template;
import org.obrii.fitdocs.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateDao templateDao;

    @Autowired
    public TemplateServiceImpl(TemplateDao templateDao) {
        this.templateDao = templateDao;
    }

    @Override
    public Template createTemplate(TemplateCreateDto body) {
        String extension = ".docx";
        Template template = new Template();
        template.setName(body.getTitle());
        template.setSourceUrl(UUID.randomUUID() + extension);
        template.setRate((byte) 0); // TODO
        template.setIsRecommended(true); // TODO

        List<FieldKey> keys = new ArrayList<>();
        List<FieldGroup> groups = new ArrayList<>();

        for (TemplateFieldDto field : body.getFields()) {
            FieldKey fieldKey = new FieldKey();
            fieldKey.setName(field.getName());
            fieldKey.setMaxLength(field.getMaxLength());
            fieldKey.setMinLength(field.getMinLength());
            fieldKey.setIsRequired(field.getIsRequired());
            fieldKey.setType(field.getType());

            boolean groupNotExist = true;
            for (FieldGroup group : groups) {
                if (group.getName().equals(field.getGroupName())) {
                    fieldKey.setGroup(group);
                    groupNotExist = false;
                }
            }

            if (groupNotExist) {
                FieldGroup fieldGroup = new FieldGroup();
                fieldGroup.setName(field.getGroupName());
                groups.add(fieldGroup);
            }

            keys.add(fieldKey);
        }

        template.setKeys(new HashSet<>(keys));
        this.templateDao.save(template);

        return template;
    }
}
