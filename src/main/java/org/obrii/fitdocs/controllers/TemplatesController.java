package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.core.FieldTypes;
import org.obrii.fitdocs.dao.TemplateDao;
import org.obrii.fitdocs.dto.TemplateCreateDto;
import org.obrii.fitdocs.dto.TemplateFieldDto;
import org.obrii.fitdocs.entity.FieldGroup;
import org.obrii.fitdocs.entity.FieldKey;
import org.obrii.fitdocs.entity.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TemplatesController extends ControllerBase {

    private final TemplateDao templateDao;

    @Autowired
    public TemplatesController(TemplateDao templateDao) {
        this.templateDao = templateDao;
    }

    @GetMapping("/templates")
    public String templates(Model model) {
        Iterable<Template> data = templateDao.findAll();
        model.addAttribute("templates", data);
        return "templates/index";
    }

    @GetMapping("/templates/construct")
    public String create(Model model) {
        model.addAttribute("fieldTypes", FieldTypes.values());
        model.addAttribute("body", new TemplateCreateDto());
        return "templates/construct";
    }

    @PostMapping("/templates/construct")
    public String createAction(@ModelAttribute TemplateCreateDto body, Model model) {
        List<String> errors = body.validate();

        if (errors.size() > 0) { // has validation errors
            model.addAttribute("errors", errors);
        } else {

        }

        return this.redirectTo("/templates");
    }

//    @GetMapping("/templates/{id}")
//    public String template(Model model, int id) {
//        Optional<Template> template = db.findById(id);
//        model.addAttribute("template", template);
//        return "/templates/" + id;
//    }
//
//    @GetMapping("/templates/{id}/edit")
//    public String edit(Model model, int id){
//        Optional<Template> template = db.findById(id);
//        model.addAttribute("template", template);
//        return "/templates";
//        //TODO: хз як працює цей action, того його треба дописати
//    }

    @PostMapping("/templates/{id}/delete")
    public String delete(@PathVariable int id){
        this.templateDao.deleteById(id);
        return "/templates";
    }


}
