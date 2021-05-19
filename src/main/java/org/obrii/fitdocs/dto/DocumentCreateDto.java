package org.obrii.fitdocs.dto;

import lombok.Data;
import org.obrii.fitdocs.core.DataTransferObject;

import java.util.List;

@Data
public class DocumentCreateDto implements DataTransferObject {

    private List<DocumentFieldDto> fields;

    @Override
    public List<String> validate() {
        return null;
    }
}
