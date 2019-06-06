package ru.burmistrov.restExample.api.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.burmistrov.restExample.entity.User;

public interface IUserServiceRequest {

    Mono<User> findUserById(String id);

    Flux<User> findAll();

    Mono<User> persist(String username, String password);

    Mono<User> merge(String id, String username, String password);

    void delete(String id);
}
