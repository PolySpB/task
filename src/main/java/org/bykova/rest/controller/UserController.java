package org.bykova.rest.controller;

import org.bykova.rest.entity.User;
import org.bykova.rest.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user_service")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{row_id}")
    public Optional<User> findById(@PathVariable("row_id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("user/{name}")
    public Optional<User> findByName(@PathVariable("name") String name) {
        return userService.findByName(name);
    }

}
