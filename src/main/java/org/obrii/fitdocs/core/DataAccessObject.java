package org.obrii.fitdocs.core;

import java.util.List;

public interface DataAccessObject<T> {
    List<T> readAll();

    T readOne(int id);

    void create(T entity);

    void update(int id, T entity);

    void delete(int id);
}
