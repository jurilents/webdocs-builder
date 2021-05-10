package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.entity.FieldKey;
import org.obrii.fitdocs.entity.FieldValue;
import org.obrii.fitdocs.service.DocumentFilesConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController extends ControllerBase {

    private final DocumentFilesConverterService filesConverterService;

    @Autowired
    public HomeController(DocumentFilesConverterService filesConverterService) {
        this.filesConverterService = filesConverterService;
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }


    @GetMapping("/test")
    public String test() throws IOException {
        FieldValue val1 = new FieldValue();
        val1.setText("Hello World");
        FieldKey key1 = new FieldKey();
        key1.setText("workProgram");
        val1.setKey(key1);

        this.filesConverterService.fillTemplate(
//                "static\\templates\\РНП -2020 - Веб-дизайн (МІТ)_robotsystem.doc",
                "static\\templates\\other.docx",
                "static\\documents\\result.docx",
                new FieldValue[]{val1});

        return "home/index";
    }

}
