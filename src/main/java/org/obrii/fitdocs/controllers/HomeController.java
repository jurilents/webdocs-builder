package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.core.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends ControllerBase {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }


    @GetMapping("/test")
    public String test() {
        return this.forbidden403();
    }

}
