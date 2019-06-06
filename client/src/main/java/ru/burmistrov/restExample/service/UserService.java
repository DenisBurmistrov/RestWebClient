package ru.burmistrov.restExample.service;

import org.springframework.stereotype.Service;
import ru.burmistrov.restExample.api.service.IUserService;
import ru.burmistrov.restExample.entity.User;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserServiceRequest userServiceRequest;

    public UserService(UserServiceRequest userServiceRequest) {
        this.userServiceRequest = userServiceRequest;
    }

    @Override
    public User findUserById(String id) {
        return userServiceRequest.findUserById(id).block();
    }

    @Override
    public List<User> findAll() {
        return userServiceRequest.findAll().collectList().block();
    }

    @Override
    public User persist(String username, String password) {
        return userServiceRequest.persist(username, password).block();
    }

    @Override
    public User merge(String id, String username, String password) {
        return userServiceRequest.merge(id, username, password).block();
    }

    @Override
    public void delete(String id) {
        userServiceRequest.delete(id);
    }
}
