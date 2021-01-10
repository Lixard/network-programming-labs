package ru.student.lab14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.lab14.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByLoginAndPassword(String login, String password);
}
