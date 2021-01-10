package ru.student.lab16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws MalformedURLException {
        final var url = new URL("http://localhost:8080/math?wsdl");
        final var qname = new QName("http://lab16.student.ru/", "MathServiceImplService");
        final var service = Service.create(url, qname);
        final var port = service.getPort(MathService.class);
        LOGGER.info("1+1 = {}", port.add(1, 1));
        LOGGER.info("2-1 = {}", port.subtract(2, 1));
        LOGGER.info("2*2 = {}", port.multiply(2, 2));
        LOGGER.info("10/5 = {}", port.divide(10, 5));
    }
}
