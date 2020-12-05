package ru.student.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsSpeedTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListsSpeedTest.class);

    public static void main(String[] args) {
        linkedListTest();
        arrayListTest();
    }

    private static void linkedListTest() {
        List<Integer> linkedList = new LinkedList<>();
        long delay = addOperations(linkedList);
        LOGGER.info("Linked list add = {}", delay);
        delay = removeOperations(linkedList);
        LOGGER.info("Linked list remove = {}", delay);
    }

    private static void arrayListTest() {
        List<Integer> arrayList = new ArrayList<>();
        long delay = addOperations(arrayList);
        LOGGER.info("Array list add = {}", delay);
        delay = removeOperations(arrayList);
        LOGGER.info("Array list remove = {}", delay);
    }

    private static long addOperations(List<Integer> list) {
        Integer digit = 2;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(digit);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long removeOperations(List<Integer> list) {
        long start = System.currentTimeMillis();
        //noinspection ListRemoveInLoop
        for (int i = 0; i < 1_000; i++) {
            list.remove(0);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

}
