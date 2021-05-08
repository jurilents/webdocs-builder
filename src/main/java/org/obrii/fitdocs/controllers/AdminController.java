package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.dao.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController extends ControllerBase {
    private final DocumentDAO documentDAO;

    @Autowired
    public AdminController(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @GetMapping("/documents")
    public String documents(Model model) {
        model.addAttribute("documents", documentDAO.readAll());
        return "admin/documents";
    }
}
