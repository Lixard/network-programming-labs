package ru.student.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsSpeedTest {
    public static void main(String[] args) {
        linkedListTest();
        arrayListTest();
    }

    private static void linkedListTest() {
        List<Integer> linkedList = new LinkedList<>();
        long delay = addOperations(linkedList);
        System.out.printf("linked list add = %d \n", delay);
        delay = removeOperations(linkedList);
        System.out.printf("linked list remove = %d \n", delay);
    }

    private static void arrayListTest() {
        List<Integer> arrayList = new ArrayList<>();
        long delay = addOperations(arrayList);
        System.out.printf("array list add = %d \n", delay);
        delay = removeOperations(arrayList);
        System.out.printf("array list remove = %d \n", delay);
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
