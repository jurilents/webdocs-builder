package org.obrii.fitdocs;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableTransactionManagement
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    LayoutDialect layout() {
        return new LayoutDialect();
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }

    @Bean
    TomcatConnectorCustomizer headerRejectionCustomizer() {
        return (connector) ->
                ((AbstractHttp11Protocol<?>)connector.getProtocolHandler()).setRejectIllegalHeader(false);
    }
}
