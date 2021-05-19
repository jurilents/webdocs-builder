package org.obrii.fitdocs.dto;

import lombok.Data;
import org.obrii.fitdocs.core.DataTransferObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class TemplateCreateDto implements DataTransferObject {

    private MultipartFile sourceFile;
    private String name;
    private List<TemplateFieldDto> fields;

    @Override
    public List<String> validate() {
        List<String> errors = new ArrayList<>();

        if (Objects.equals(this.getName(), "")) {
            errors.add("Назва закоротка");
        } else if (this.getName().length() > 128) {
            errors.add("Назва задовга");
        }

        if (this.getSourceFile() == null || this.getSourceFile().isEmpty()) {
            errors.add("Виберіть файл шаблону");
        }

//        if (this.getSourceFile().getContentType() ) // TODO check mime type for pdf and docx files

        if (this.fields == null || this.fields.size() == 0) {
            errors.add("Не задано жодного поля");
        }

        return errors;
    }
}
