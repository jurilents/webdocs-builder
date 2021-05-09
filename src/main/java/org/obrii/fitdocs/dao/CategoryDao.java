package org.obrii.fitdocs.dao;

import org.obrii.fitdocs.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
