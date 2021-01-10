package ru.student.lab16;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/math", new MathServiceImpl());
    }
}
