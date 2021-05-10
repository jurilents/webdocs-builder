package org.obrii.fitdocs.dao;

import org.obrii.fitdocs.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
