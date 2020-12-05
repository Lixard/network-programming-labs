package ru.student.objects;

import ru.student.annotation.HaveArea;
import ru.student.annotation.ReturnArea;

import java.util.concurrent.ThreadLocalRandom;

@HaveArea(name = "circle")
public class Circle {

    private final double radius = ThreadLocalRandom.current().nextDouble();


    @ReturnArea
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
