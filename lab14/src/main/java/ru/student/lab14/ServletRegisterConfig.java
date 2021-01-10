package ru.student.lab14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.student.lab14.repository.UserRepository;
import ru.student.lab14.servlet.AuthServlet;
import ru.student.lab14.servlet.HelloServlet;

@Configuration
public class ServletRegisterConfig {

    private final UserRepository userRepository;

    @Autowired
    public ServletRegisterConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public ServletRegistrationBean authServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new AuthServlet(), "/login");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean helloServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet(userRepository), "/hello");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
