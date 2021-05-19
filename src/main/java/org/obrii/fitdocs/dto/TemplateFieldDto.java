package org.obrii.fitdocs.dto;

import lombok.Data;
import org.obrii.fitdocs.core.DataTransferObject;

import java.util.List;

@Data
public class TemplateFieldDto implements DataTransferObject {

    private String name;
    private Integer minLength;
    private Integer maxLength;
    private Integer isRequired;

    private String groupName;
    private Short type;

    @Override
    public List<String> validate() {
        // TODO: add fields validation
        return null;
    }
}
