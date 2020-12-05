package ru.student;

import ru.student.objects.Child;
import ru.student.objects.Circle;
import ru.student.objects.Square;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final var list = List.of(new Child(), new Circle(), new Square());
        final var areaCounter = new AreaCounter();
        list.forEach(areaCounter::countArea);
    }
}
