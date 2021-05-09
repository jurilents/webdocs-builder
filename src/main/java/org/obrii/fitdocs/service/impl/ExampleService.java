package org.obrii.fitdocs.service.impl;

import org.obrii.fitdocs.dao.FieldKeyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/*

@Service
public class ExampleService implements TeacherService {

    private final FieldKeyDao teacherDAO;

    @Autowired
    public ExampleService(FieldKeyDao teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addReview(String teacherID, Review review){
        Objects.requireNonNull(teacherID);
        Objects.requireNonNull(review);

        Teacher teacher = teacherDAO
                .findById(UUID.fromString(teacherID))
                .orElseThrow(() -> new EntityNotFoundException(teacherID));

        review.setDate(LocalDate.now());

        if(teacher.getReviews() == null){
            teacher.setReviews(new ArrayList<>());
        }

        teacher.getReviews().add(review);

        teacherDAO.save(teacher);

    }
}

*/