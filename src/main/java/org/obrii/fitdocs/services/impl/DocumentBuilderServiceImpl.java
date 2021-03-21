package org.obrii.fitdocs.services.impl;

import org.obrii.fitdocs.core.ServiceBase;
import org.obrii.fitdocs.models.Document;
import org.obrii.fitdocs.services.DocumentsBuilderService;

public class DocumentBuilderServiceImpl extends ServiceBase implements DocumentsBuilderService {

    @Override
    public boolean buildPDF(Document document, String destPath) {
        throw new UnsupportedOperationException();
    }
}
