package org.obrii.fitdocs.dao;

import org.obrii.fitdocs.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}
