package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.dao.DocumentDao;
import org.obrii.fitdocs.dao.TemplateDao;
import org.obrii.fitdocs.entity.Document;
import org.obrii.fitdocs.entity.FieldKey;
import org.obrii.fitdocs.entity.FieldValue;
import org.obrii.fitdocs.service.DocumentFilesConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController extends ControllerBase {

    private final DocumentFilesConverterService filesConverterService;
    private final DocumentDao documentDao;
    private final TemplateDao templateDao;

    @Autowired
    public HomeController(
            DocumentFilesConverterService filesConverterService,
            DocumentDao documentDao,
            TemplateDao templateDao) {
        this.filesConverterService = filesConverterService;
        this.documentDao = documentDao;
        this.templateDao = templateDao;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("documents", this.documentDao.findAll());
        model.addAttribute("templates", this.templateDao.findAll());
        return "home/index";
    }


    @GetMapping("/test")
    public String test() throws IOException {
        FieldValue val1 = new FieldValue();
        val1.setText("Hello World");
        FieldKey key1 = new FieldKey();
        key1.setName("workProgram");
        val1.setKey(key1);

//        this.filesConverterService.fillTemplate(
//                // "static\\templates\\РНП -2020 - Веб-дизайн (МІТ)_robotsystem.doc",
//                "static\\templates\\other.docx",
//                "static\\documents\\result.docx",
//                new FieldValue[]{});

        return "home/index";
    }

    @GetMapping("/about")
    public String about() {
        return "home/about";
    }

    @GetMapping("/developers")
    public String developers() {
        return "home/developers";
    }

}
