package ru.student.lab17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.student.lab17.repository.ProductRepository;
import ru.student.lab17.servlet.ProductServlet;

@Configuration
public class ServletRegisterConfig {

    private final ProductRepository productRepository;

    @Autowired
    public ServletRegisterConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ServletRegistrationBean<ProductServlet> productServletRegistration() {
        final var bean = new ServletRegistrationBean<>(new ProductServlet(productRepository), "/basket");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
