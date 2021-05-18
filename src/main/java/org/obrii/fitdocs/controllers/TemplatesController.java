package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.obrii.fitdocs.dao.TemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController extends ControllerBase {

    private final TemplateDao db;

    @Autowired
    public TemplatesController(TemplateDao db) {
        this.db = db;
    }

    @GetMapping("/templates")
    public String templates(Model model) {
//        Iterable data = db.findAll();
//        model.addAttribute("templates", data);
        return "templates/templates";
    }

//    @GetMapping("/templates/create")
//    public String create(){ return "/templates/create";}
//
//
//
//    @GetMapping("/templates/{id}")
//    public String template(Model model, int id){
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
//
//    @PostMapping("/templates/{id}/delete")
//    public String delete(int id){
//        db.deleteById(id);
//        return "/templates";
//    }




}