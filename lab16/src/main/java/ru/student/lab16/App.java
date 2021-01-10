package ru.student.lab16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        new SpringApplication(App.class).run(args);
    }

    @Bean
    public ServletRegistrationBean<MathServlet> mathServletRegistration() {
        final var bean = new ServletRegistrationBean<>(new MathServlet(), "/math");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
