package ru.burmistrov.restExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.burmistrov.restExample.entity.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User save(final User user);

    void delete(final User user);

    @Query(value = "SELECT user FROM User user")
    List<User> findAllUsers();

    @Query(value = "SELECT user FROM User user WHERE user.id = :id")
    User findOne(@Param(value = "id") final String id);
}
