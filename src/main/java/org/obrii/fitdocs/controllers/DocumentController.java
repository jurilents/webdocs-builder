package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.dao.DocumentDao;
import org.obrii.fitdocs.dao.TemplateDao;
import org.obrii.fitdocs.dto.DocumentCreateDto;
import org.obrii.fitdocs.dto.DocumentFieldDto;
import org.obrii.fitdocs.entity.*;
import org.obrii.fitdocs.service.DocumentFilesConverterService;
import org.obrii.fitdocs.service.DocumentService;
import org.obrii.fitdocs.utils.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

@Controller
public class DocumentController extends ControllerBase {

    private final DocumentDao documentDao;
    private final TemplateDao templateDao;
    private final DocumentService documentService;

    @Autowired
    public DocumentController(
            DocumentDao documentDao,
            TemplateDao templateDao,
            DocumentService documentService) {
        this.documentDao = documentDao;
        this.templateDao = templateDao;
        this.documentService = documentService;
    }


    @GetMapping("/documents/archive")
    public String index(Model model) {
        model.addAttribute("documents", documentDao.findAll());
        return "documents/index";
    }

    @GetMapping("/documents/construct/{templateId}")
    public String create(@PathVariable int templateId, Model model) {
        Optional<Template> template = this.templateDao.findById(templateId);

        if (template.isPresent()) {
            Document document = new Document();
            this.documentDao.save(document);

            model.addAttribute("template", template.get());
            model.addAttribute("document", document);
            return "documents/construct";
        } else {
            return this.notFound404();
        }
    }

    @PostMapping("/documents/construct/{templateId}")
    public String createAction(@PathVariable int templateId, @RequestBody DocumentCreateDto body, Model model) throws IOException {
        Optional<Template> template = this.templateDao.findById(templateId);

        if (template.isPresent()) {
            model.addAttribute("template", template.get());

            List<String> errors = body.validate();
            if (errors.size() > 0) { // has validation errors
                model.addAttribute("errors", errors);
                return MessageFormat.format("documents/create/{0}", templateId);
            } else {
                // TODO: look for this code

                List<FieldValue> values = new ArrayList<>();

                for (DocumentFieldDto field : body.getFields()) {
                    FieldValue fieldValue = new FieldValue();
                    fieldValue.setText(field.getText());
                    values.add(fieldValue);
                }

                Document document = this.documentService.createForAnonymousUser(template.get(), values);

                return this.redirectTo(String.format("/documents/%d/download", document.getId()));
            }

        } else {
            return this.notFound404();
        }
    }

//    @GetMapping("/documents/{id}")
//    public String id(Model model, int id) {
//        Optional<Document> document = documentDao.findById(id);
//        model.addAttribute("document", document);
//        return "documents/" + id;
//    }

//    @GetMapping("/documents/{id}/edit")
//    public String edit(Model model, int id) {
//        //TODO: continue
//        Optional<Document> document = db.findById(id);
//        model.addAttribute("document", document);
//        return "/documents";
//    }
//
//    @GetMapping("/documents/{id}/delete")
//    public String delete(int id) {
//        db.deleteById(id);
//        return "/documents";
//    }

    @GetMapping("/documents/{id}/download")
    public byte[] download(@PathVariable int id) throws FileNotFoundException {
        Optional<Document> document = this.documentDao.findById(id);

        if (document.isPresent()) {
            return Resources.getFileBinary(document.get().getResultUrl());
        } else {
            throw new FileNotFoundException();
        }
    }
}