package ru.burmistrov.restExample.api.service;

import ru.burmistrov.restExample.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUsers();

    User findOneById(final String id);

    User persist(final String username, final String password);

    User merge(final String id, final String username, final String password);

    void deleteById(final String id);
}
