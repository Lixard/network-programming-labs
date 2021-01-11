package ru.student.lab16.webservice;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/math", new MathServiceImpl());
    }
}
