package org.obrii.fitdocs.service;

import org.obrii.fitdocs.core.DocType;
import org.obrii.fitdocs.entities.FieldKey;

public interface DocumentFilesConverterService {
    void fillTemplate(String sourcePath, String destinationPath, FieldKey[] values); // DocType = DocType.PDF as default

    void fillTemplate(String sourcePath, String destinationPath, FieldKey[] values, DocType docType);
}
