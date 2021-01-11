package ru.student.lab16.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.student.lab16.webservice.MathService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class Client {

    public static void main(String[] args) {
        new SpringApplication(Client.class).run(args);
    }

    @Bean
    public MathService mathService() throws MalformedURLException {
        final var url = new URL("http://localhost:8081/math?wsdl");
        final var qname = new QName("http://webservice.lab16.student.ru/", "MathServiceImplService");
        final var service = Service.create(url, qname);
        return service.getPort(MathService.class);
    }


}
