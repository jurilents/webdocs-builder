package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.dao.DocumentDAO;
import org.obrii.fitdocs.models.Document;
import org.obrii.fitdocs.services.DocumentsBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {

    private final DocumentsBuilderService documentsBuilderService;
    private final DocumentDAO documentDAO;

    @Autowired
    public FormController(DocumentsBuilderService documentsBuilderService, DocumentDAO documentDAO) {
        this.documentsBuilderService = documentsBuilderService;
        this.documentDAO = documentDAO;
    }


    @GetMapping
    public String index() {
        return "form/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("document") Document document) {

        // TODO: add logic here...

        return "redirect:/form/success";
    }

    @GetMapping
    public String success(Model model) {
        return "form/success";
    }

    @GetMapping
    public String error(Model model) {
        return "shared/error";
    }
}
