package ru.student.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueStudents {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueStudents.class);

    private static final List<Student> students = createStudents();

    private static List<Student> createStudents() {
        final var result = new ArrayList<Student>();
        result.add(new Student.Builder().withSurname("Ivanov").withAvgGrade(2.3).withAge(18).build());
        result.add(new Student.Builder().withSurname("Borisov").withAvgGrade(4.9).withAge(17).build());
        result.add(new Student.Builder().withSurname("Borisov").withAvgGrade(4.9).withAge(17).build());
        return result;
    }

    public void filterUniqueStudents() {
        new HashSet<>(students).forEach(s -> LOGGER.info(s.toString()));
    }
}
