package org.obrii.fitdocs.controllers;

import org.obrii.fitdocs.dto.TimetableDto;
import org.obrii.fitdocs.service.FieldDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    // TODO: ...

    private final FieldDataService fieldDataService;

    @Autowired
    public ApiController(FieldDataService fieldDataService) {
        this.fieldDataService = fieldDataService;
    }

    @PostMapping("/update/from-timetable")
    public ResponseEntity<Object> updateDataFromTimetable(@RequestBody TimetableDto timetable) {

        try {
            fieldDataService.saveDataFromTimetable(timetable);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
