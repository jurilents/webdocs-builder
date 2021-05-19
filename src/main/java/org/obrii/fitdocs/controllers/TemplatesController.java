package org.obrii.fitdocs.controllers;

import org.apache.commons.collections4.set.ListOrderedSet;
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

    @GetMapping("/templates/create")
    public String create(Model model) {
        model.addAttribute("fieldTypes", FieldTypes.values());
        model.addAttribute("body", new TemplateCreateDto());
        return "templates/create";
    }

    @PostMapping("/templates/create")
    public String createAction(@ModelAttribute TemplateCreateDto body, Model model) {
        List<String> errors = body.validate();
        if (errors.size() > 0) { // has validation errors
            model.addAttribute("errors", errors);
        } else {
            String extension = ".docx";
            Template template = new Template();
            template.setName(body.getTitle());
            template.setSourceUrl(UUID.randomUUID() + extension);
            template.setRate((byte) 0); // TODO
            template.setIsRecommended(true); // TODO

            List<FieldKey> keys = new ArrayList<>();
            List<FieldGroup> groups = new ArrayList<>();

            for (TemplateFieldDto field : body.getFields()) {
                FieldKey fieldKey = new FieldKey();
                fieldKey.setName(field.getName());
                fieldKey.setMaxLength(field.getMaxLength());
                fieldKey.setMinLength(field.getMinLength());
                fieldKey.setIsRequired(field.getIsRequired());
                fieldKey.setType(field.getType());

                boolean groupNotExist = true;
                for (FieldGroup group : groups) {
                    if (group.getName().equals(field.getGroupName())) {
                        fieldKey.setGroup(group);
                        groupNotExist = false;
                    }
                }

                if (groupNotExist) {
                    FieldGroup fieldGroup = new FieldGroup();
                    fieldGroup.setName(field.getGroupName());
                    groups.add(fieldGroup);
                }

                keys.add(fieldKey);
            }

            template.setKeys(new HashSet<>(keys));
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
