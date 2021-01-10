package ru.student.lab14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        final var springApplication = new SpringApplication(App.class);
        springApplication.setLogStartupInfo(false);
        springApplication.run(args);
    }
}
