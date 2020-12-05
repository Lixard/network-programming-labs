package ru.student.objects;

public class Child {

    private final String name = "Chelik";

    public String getName() {
        return name;
    }

    public void doNothing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
