package org.obrii.fitdocs.dao;

import org.obrii.fitdocs.entities.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentDao extends CrudRepository<Document, Integer> {

}
