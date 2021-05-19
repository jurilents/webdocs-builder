package org.obrii.fitdocs.service.impl;

import org.obrii.fitdocs.dao.DocumentDao;
import org.obrii.fitdocs.dao.FieldValueDao;
import org.obrii.fitdocs.entity.Document;
import org.obrii.fitdocs.entity.FieldValue;
import org.obrii.fitdocs.entity.Template;
import org.obrii.fitdocs.entity.User;
import org.obrii.fitdocs.service.DocumentFilesConverterService;
import org.obrii.fitdocs.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;
    private final FieldValueDao fieldValueDao;
    private final DocumentFilesConverterService documentFilesConverterService;

    @Autowired
    public DocumentServiceImpl(
            DocumentDao documentDao,
            FieldValueDao fieldValueDao,
            DocumentFilesConverterService documentFilesConverterService) {
        this.documentDao = documentDao;
        this.fieldValueDao = fieldValueDao;
        this.documentFilesConverterService = documentFilesConverterService;
    }

    @Override
    public Document createForAnonymousUser(Template template, List<FieldValue> values) throws IOException {
        Document document = new Document();

        String destinationPath = UUID.randomUUID() + ".docs";
        this.documentFilesConverterService.fillTemplate(template.getSourceUrl(), destinationPath, values);

        document.setResultUrl(destinationPath);
        document.setTemplate(template);

        document.setValues(new HashSet<>(values));
        document.setCreationDate(new Date(System.currentTimeMillis()));

        this.documentDao.save(document);
        this.fieldValueDao.saveAll(values);
        return document;
    }

    @Override
    public Document createForUser(User user, Template template, List<FieldValue> values) {
        return null;
    }
}
