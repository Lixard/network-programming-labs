package ru.student.lab15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.lab15.entity.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
