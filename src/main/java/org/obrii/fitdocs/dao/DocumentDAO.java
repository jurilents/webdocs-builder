package org.obrii.fitdocs.dao;

import org.obrii.fitdocs.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentDAO extends CrudRepository<Document, Integer> {

}