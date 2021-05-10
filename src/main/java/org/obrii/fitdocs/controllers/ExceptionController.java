package org.obrii.fitdocs.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    @ExceptionHandler({Exception.class})
    public String error(
            @RequestParam(value = "code", required = false, defaultValue = "404") int code,
            @RequestParam(value = "msg", required = false, defaultValue = "") String message,
            Model model) {

        model.addAttribute("errorCode", code);
        model.addAttribute("errorMessage", message);
        return "shared/error";
    }
}

