package ru.student.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        final var studentSort = new StudentSort();

        LOGGER.info("Sort students by TreeMap");
        studentSort.sortByTreeMap();

        LOGGER.info("Sort students by Comparator");
        studentSort.sortByComparator();

        final var uniqueStudents = new UniqueStudents();

        LOGGER.info("Filter students by HashSet");
        uniqueStudents.filterUniqueStudents();
    }
}
