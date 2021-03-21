package org.obrii.fitdocs.core;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class DAOBase {
    protected final JdbcTemplate jdbc;

    public DAOBase(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    protected <T> T firstOrNull(List<T> list) {
        return list.stream().findAny().orElse(null);
    }
}
