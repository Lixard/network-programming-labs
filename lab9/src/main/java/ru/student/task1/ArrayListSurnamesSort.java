package ru.student.task1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayListSurnamesSort {

    private static final int SURNAMES_LENGTH = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>(SURNAMES_LENGTH);
        for (int i = 1; i <= SURNAMES_LENGTH; i++) {
            System.out.print(i + ". ");
            input.add(in.nextLine());
        }
        in.close();

        System.out.println("--- Sorted ---");
        input.sort(String::compareToIgnoreCase);
        input.forEach(System.out::println);

        System.out.println("--- Counted ---");
        input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((surname, occurrences) -> System.out.println(surname + " : " + occurrences));

        System.out.println("--- Distinct ---");
        input.stream().distinct().forEachOrdered(System.out::println);

    }
}
