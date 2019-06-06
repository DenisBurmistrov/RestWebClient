package ru.burmistrov.restExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.burmistrov.restExample.entity.User;
import ru.burmistrov.restExample.repository.IUserRepository;

@SpringBootApplication
public class ApplicationServer {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationServer.class, args);

        User user = new User();
        user.setId("1");
        user.setUsername("FIRST");
        user.setPassword("FIRST");
        IUserRepository userRepository = context.getBean(IUserRepository.class);
        userRepository.save(user);
    }
}
