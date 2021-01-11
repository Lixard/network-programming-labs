package ru.student.lab16.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.student.lab16.webservice.MathService;

@Configuration
public class ServletRegistrationConfig {

    private final MathService mathService;

    @Autowired
    public ServletRegistrationConfig(MathService mathService) {
        this.mathService = mathService;
    }

    @Bean
    public ServletRegistrationBean<MathServlet> mathServletRegistration() {
        final var servlet = new ServletRegistrationBean<MathServlet>(new MathServlet(mathService), "/math");
        servlet.setLoadOnStartup(1);
        return servlet;
    }
}
