//package org.obrii.fitdocs.controllers.api;
//
//import org.obrii.fitdocs.core.ControllerBase;
//import org.obrii.fitdocs.dao.DocumentDAO;
//import org.obrii.fitdocs.entity.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import java.util.Optional;
//
//@Controller
//public class DocumentController extends ControllerBase {
//
//    private final DocumentDAO db;
//
//    @Autowired
//    public DocumentController(DocumentDAO db){
//        this.db = db;
//    }
//
//    @GetMapping("/documents")
//    public String index(Model model) {
//        Iterable data = db.findAll();
//        model.addAttribute("document", data);
//        return "/documents";
//    }
//
//    @GetMapping("/documents/create")
//    public String create() { return "/documents/create"; }
//
//    @GetMapping("/documents/{id}")
//    public String id(Model model, int id) {
//        Optional<Document> document = db.findById(id);
//        model.addAttribute("document", document);
//        return "/documents/" + id;
//    }
//
////    @GetMapping("/documents/{id}/edit")
////    public String edit(Model model, int id) {
////        //TODO: continue
////        Optional<Document> document = db.findById(id);
////        model.addAttribute("document", document);
////        return "/documents";
////    }
////
////    @GetMapping("/documents/{id}/delete")
////    public String delete(int id) {
////        db.deleteById(id);
////        return "/documents";
////    }
//
//    @GetMapping("/documents/{id}/download")
//    public String download(int id) {
//        //TODO: continue
//        return "/documents";
//    }
//}