package org.bykova.rest.service.api;

import org.bykova.rest.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

}
