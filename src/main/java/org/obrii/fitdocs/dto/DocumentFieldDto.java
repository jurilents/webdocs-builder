package org.obrii.fitdocs.dto;

import lombok.Data;
import org.obrii.fitdocs.core.DataTransferObject;

import java.util.List;

@Data
public class DocumentFieldDto implements DataTransferObject {

    private String text;
    private Short type;
    private int keyId;

    @Override
    public List<String> validate() {
        return null;
    }
}
