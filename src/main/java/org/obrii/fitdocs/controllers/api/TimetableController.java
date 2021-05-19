package org.obrii.fitdocs.controllers.api;

import org.obrii.fitdocs.service.FieldDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TimetableController {

    private final FieldDataService fieldDataService;

    @Autowired
    public TimetableController(FieldDataService fieldDataService) {
        this.fieldDataService = fieldDataService;
    }

    @PostMapping("/update/from-timetable")
    public ResponseEntity<Object> updateDataFromTimetable(@RequestBody List<Map<String, String>> timetable) {

        try {
            fieldDataService.saveDataFromTimetable(timetable);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
