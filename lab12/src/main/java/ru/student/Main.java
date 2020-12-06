package ru.student;

import ru.student.generator.XmlGenerator;
import ru.student.model.Student;
import ru.student.reader.XmlReader;

import java.util.List;

public class Main {

    public static final String XML_FILE_PATH = "lab12/src/main/resources/file.xml";

    public static void main(String[] args) {
        final var students = List.of(
                new Student("Maxim", "Borisov"),
                new Student("Ivan", "Ivanov"),
                new Student("Vanya", "Vanovich")
        );

        new XmlGenerator().generateFileFromList(students);
        new XmlReader().readFromFile();
    }
}
