package ru.student;

import ru.student.generator.XmlGenerator;
import ru.student.model.Student;
import ru.student.reader.XmlReader;

import java.util.List;

public class Main {
    public static final String XML_FILE_PATH = "11_lab/src/main/resources/file.xml";

    private static final List<Student> students = List.of(
            new Student("Maxim", "Borisov"),
            new Student("Ivan", "Ivanov"),
            new Student("Ilya", "Vasechkin")
    );

    public static void main(String[] args) {
        new XmlGenerator().createFileFromStudents(students);
        new XmlReader().readFromFile();
    }
}
