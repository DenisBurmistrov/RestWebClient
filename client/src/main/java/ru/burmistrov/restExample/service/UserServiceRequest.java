package ru.burmistrov.restExample.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.burmistrov.restExample.api.service.IUserServiceRequest;
import ru.burmistrov.restExample.entity.User;


@Service
public class UserServiceRequest implements IUserServiceRequest {

    private static final String API_BASE_URL = "http://localhost:8080/user";

    private final WebClient webClient;

    public UserServiceRequest() {
        this.webClient = WebClient.builder()
                .baseUrl(API_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public Mono<User> findUserById(String id) {
        return webClient.get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(User.class);
    }

    @Override
    public Flux<User> findAll() {
        return webClient.get()
                .uri("/list")
                .retrieve()
                .bodyToFlux(User.class);
    }

    @Override
    public Mono<User> persist(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        BodyInserter<Object, ReactiveHttpOutputMessage> insert
                = BodyInserters.fromObject(user);

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(insert)
                .retrieve().bodyToMono(User.class);
    }

    @Override
    public Mono<User> merge(String id, String username, String password) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        BodyInserter<Object, ReactiveHttpOutputMessage> insert
                = BodyInserters.fromObject(user);

        return webClient.put()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(insert)
                .retrieve().bodyToMono(User.class);
    }

    @Override
    public void delete(String id) {
        webClient.delete()
                .uri("/remove/" + id).retrieve().bodyToMono(Void.class).block();
    }
}
