package ru.student.objects;

import ru.student.annotation.HaveArea;
import ru.student.annotation.ReturnArea;

import java.util.concurrent.ThreadLocalRandom;

@HaveArea(name = "square")
public class Square {

    private final double side = ThreadLocalRandom.current().nextDouble();

    @ReturnArea
    public double getArea() {
        return Math.pow(side, 2);
    }
}
