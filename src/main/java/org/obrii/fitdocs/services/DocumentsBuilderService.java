package org.obrii.fitdocs.services;

import org.obrii.fitdocs.models.Document;

public interface DocumentsBuilderService {
    /**
     * Generates a new .pdf file based on data from raw Document object
     *
     * @param document document object created from user form data
     * @param destPath relative path to write result file
     * @return operation war success
     */
    boolean buildPDF(Document document, String destPath);
}
