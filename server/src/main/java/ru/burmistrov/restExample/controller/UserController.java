package ru.burmistrov.restExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.burmistrov.restExample.api.service.IUserService;
import ru.burmistrov.restExample.entity.User;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findProjectById(@PathVariable final String id) {
        return userService.findOneById(id);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllProjects() {
        return userService.findAllUsers();
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User persist(@RequestBody final User user) {
        return userService.persist(user.getUsername(), user.getPassword());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User merge(@RequestBody final User user) {
        return userService.merge(user.getId(), user.getUsername(), user.getPassword());
    }

    @DeleteMapping( value = "/remove/{id}")
    public void delete(@PathVariable final String id) {
        userService.deleteById(id);
    }

}
