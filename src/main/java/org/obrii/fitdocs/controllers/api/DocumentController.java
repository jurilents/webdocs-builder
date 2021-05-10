package org.obrii.fitdocs.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DocumentController {

    @GetMapping("/document/convert")
    public String convert(String src, String dest) {
        return "{\"success\":true,\"statusCode\":200}";
    }
}
