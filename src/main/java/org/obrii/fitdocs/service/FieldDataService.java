package org.obrii.fitdocs.service;

import com.sun.istack.NotNull;
import org.obrii.fitdocs.dto.TimetableDto;

public interface FieldDataService {

    void saveDataFromTimetable(@NotNull TimetableDto timetable);
}
