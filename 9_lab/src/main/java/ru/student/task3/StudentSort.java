package ru.student.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSort.class);

    private static final List<Student> students = createStudents();

    private static List<Student> createStudents() {
        final var result = new ArrayList<Student>();
        result.add(new Student.Builder().withSurname("Ivanov").withAvgGrade(2.3).withAge(18).build());
        result.add(new Student.Builder().withSurname("Borisov").withAvgGrade(4.9).withAge(17).build());
        result.add(new Student.Builder().withSurname("Stepanov").withAvgGrade(3.33).withAge(19).build());
        result.add(new Student.Builder().withSurname("Chushkov").withAvgGrade(4.2).withAge(17).build());
        result.add(new Student.Builder().withSurname("Jidkov").withAvgGrade(2.8).withAge(18).build());
        return result;
    }

    /**
     * Создаем TreeMaр и отправляем в логгер отсортированных студентов
     */
    public void sortByTreeMap() {
        final var studentsGradeToMap = students.stream().collect(Collectors.toMap(Student::getAvgGrade,
                Function.identity(), (o, o2) -> {
                    LOGGER.error("Dublicate keys found: {}, {}", o, o2);
                    return o;
                }, TreeMap::new));
        studentsGradeToMap.values().forEach(s -> LOGGER.info(s.toString()));
    }


    public void sortByComparator() {
        final var comparator = Comparator
                .comparing(Student::getSurname)
                .thenComparing(Student::getAge)
                .thenComparing(Student::getAvgGrade);

        createStudents().stream().sorted(comparator).forEach(s -> LOGGER.info(s.toString()));
    }

}
