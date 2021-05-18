package org.obrii.fitdocs;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WebApplication {

    @Bean
    LayoutDialect layout(){ return new LayoutDialect();}

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
