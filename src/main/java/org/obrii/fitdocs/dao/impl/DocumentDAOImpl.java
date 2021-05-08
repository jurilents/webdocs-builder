package org.obrii.fitdocs.dao.impl;

import org.obrii.fitdocs.core.DAOBase;
import org.obrii.fitdocs.dao.DocumentDAO;
import org.obrii.fitdocs.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DocumentDAOImpl extends DAOBase implements DocumentDAO {

    @Autowired
    public DocumentDAOImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Document> readAll() {
        String sql = "SELECT * FROM Documents";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Document.class));
    }

    @Override
    public Document readOne(int id) {
        String sql = "SELECT * FROM Documents WHERE id=?";
        List<Document> result = this.jdbc.query(sql, new Object[]{ id }, new BeanPropertyRowMapper<>(Document.class));
        return firstOrNull(result);
    }

    @Override
    public void create(Document document) {
        String sql = "INSERT INTO Documents(name, age, email) VALUES(?, ?, ?)";
        this.jdbc.update(sql, document.getName());
    }

    @Override
    public void update(int id, Document document) {
        String sql = "UPDATE Documents SET name=? WHERE id=?";
        this.jdbc.update(sql, document.getName(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Documents WHERE id=?";
        this.jdbc.update(sql, id);
    }
}
