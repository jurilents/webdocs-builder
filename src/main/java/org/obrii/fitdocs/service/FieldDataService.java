package org.obrii.fitdocs.service;

import com.sun.istack.NotNull;
import org.obrii.fitdocs.dto.TimetableDto;

import java.util.List;
import java.util.Map;

public interface FieldDataService {

    void saveDataFromTimetable(@NotNull List<Map<String, String>> timetable);
}
