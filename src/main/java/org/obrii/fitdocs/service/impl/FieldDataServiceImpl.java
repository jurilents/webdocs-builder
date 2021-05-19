package org.obrii.fitdocs.service.impl;

import org.obrii.fitdocs.service.FieldDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FieldDataServiceImpl implements FieldDataService {

    @Override
    public void saveDataFromTimetable(List<Map<String, String>> timetable) {
        for (Map<String, String> tableItem : timetable) {
            for (String key : tableItem.keySet()) {

            }
        }
    }
}
