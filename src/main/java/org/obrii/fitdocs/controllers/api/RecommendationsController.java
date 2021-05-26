package org.obrii.fitdocs.controllers.api;

import org.obrii.fitdocs.dao.DocumentDao;
import org.obrii.fitdocs.dao.FieldValueDao;
import org.obrii.fitdocs.dao.TemplateDao;
import org.obrii.fitdocs.entity.Document;
import org.obrii.fitdocs.entity.FieldKey;
import org.obrii.fitdocs.entity.FieldValue;
import org.obrii.fitdocs.entity.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RecommendationsController {

    private final DocumentDao documentDao;
    private final TemplateDao templateDao;
    private final FieldValueDao fieldValueDao;

    @Autowired
    public RecommendationsController(
            DocumentDao documentDao,
            TemplateDao templateDao,
            FieldValueDao fieldValueDao) {
        this.documentDao = documentDao;
        this.templateDao = templateDao;
        this.fieldValueDao = fieldValueDao;
    }

    @GetMapping("/recommedations/for-document")
    public Map<String, List<String>> get(
            @RequestParam(name = "template") int templateId,
            @RequestParam(name = "k") String key,
            @RequestParam(name = "v") String value) {

        Optional<Template> template = this.templateDao.findById(templateId);

        if (!template.isPresent()) {
            return null;
        }

        Map<String, List<String>> fieldsMap = new HashMap<>();

        for (Document document : this.documentDao.findAll()) {
            if (document.getValues().stream()
                    .allMatch(f -> f.getKey().getName().equals(key) && f.getText().equals(value))) {

                for (FieldValue fieldValue : document.getValues()) {
                    FieldKey fieldKey = fieldValue.getKey();

                    if (fieldsMap.containsKey(fieldKey.getName())) {
                        fieldsMap.put(fieldKey.getName(), new ArrayList<>());
                    }

                    if (fieldsMap.get(fieldKey.getName()).contains(fieldValue.getText())) {
                        continue;
                    }

                    fieldsMap.get(fieldKey.getName()).add(fieldValue.getText());
                }

            }
        }

        return fieldsMap;
    }
}
