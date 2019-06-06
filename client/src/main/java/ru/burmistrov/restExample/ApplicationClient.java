package ru.burmistrov.restExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.burmistrov.restExample.api.service.IUserService;

@SpringBootApplication
public class ApplicationClient {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationClient.class, args);
        IUserService userService = context.getBean(IUserService.class);

        System.out.println("FIND ALL: " + userService.findAll());
        System.out.println("FIND ONE: " + userService.findUserById("1"));
        System.out.println("PERSIST: " + userService.persist("test", "test"));
        System.out.println("FIND ALL: " + userService.findAll());
        System.out.println("MERGE: " + userService.merge("1", "test merge", "test merge"));
        System.out.println("FIND ALL: " + userService.findAll());
        userService.delete("1");
        System.out.println("FIND ALL AFTER DELETE: " + userService.findAll());
    }
}