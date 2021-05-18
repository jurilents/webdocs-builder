package org.obrii.fitdocs.service;

import org.obrii.fitdocs.utils.DocType;
import org.obrii.fitdocs.entity.FieldValue;

import java.io.IOException;
import java.util.List;

public interface DocumentFilesConverterService {
    /**
     * Generates a new .docx file based on a template.
     * <p>
     * DocType = DocType.Word as default
     *
     * @param sourcePath      Source file relative path from resources folder
     * @param destinationPath Destination file relative path from resources folder
     * @param values          An array of values with associated keys to fill the document with them
     */
    void fillTemplate(String sourcePath, String destinationPath, List<FieldValue> values) throws IOException;

    /**
     * Generates a new .docx file based on a template with customizable destination file extension.
     *
     * @param sourcePath      Source file relative path from resources folder
     * @param destinationPath Destination file relative path from resources folder
     * @param values          An array of values with associated keys to fill the document with them
     * @param docType         Save document extension
     */
    void fillTemplate(String sourcePath, String destinationPath, List<FieldValue> values, DocType docType) throws IOException;
}
