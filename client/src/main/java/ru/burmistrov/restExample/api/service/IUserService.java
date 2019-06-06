package ru.burmistrov.restExample.api.service;

import ru.burmistrov.restExample.entity.User;

import java.util.List;

public interface IUserService {

    User findUserById(String id);

    List<User> findAll();

    User persist(String username, String password);

    User merge(String id, String username, String password);

    void delete(String id);
}
