package ru.burmistrov.restExample.service;

import org.springframework.stereotype.Service;
import ru.burmistrov.restExample.api.service.IUserService;
import ru.burmistrov.restExample.entity.User;
import ru.burmistrov.restExample.repository.IUserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findOneById(final String id){
        return userRepository.findOne(id);
    }

    public User persist(final String username, final String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User merge(final String id, final String username, final String password) {
        User user = userRepository.findOne(id);
        if(user != null) {
            user.setUsername(username);
            user.setPassword(password);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteById(final String id){
        User user = userRepository.findOne(id);
        if(user != null) {
            userRepository.delete(user);
        }
    }
}
