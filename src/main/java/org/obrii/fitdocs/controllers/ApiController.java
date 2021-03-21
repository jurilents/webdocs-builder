package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.dao.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController extends ControllerBase {

    private final DocumentDAO documentDAO;

    @Autowired
    public ApiController(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

}
