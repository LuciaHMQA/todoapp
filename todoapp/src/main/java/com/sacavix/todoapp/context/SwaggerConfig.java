package com.sacavix.todoapp.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//La clase anotada con configuration tiene la capacidad de crear beans
//Estos beans se utilizarán dentro del apliccation context de nuestra aplicación.
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sacavix.todoapp.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Lucy API",
                "La API REST de Lucy.",
                "v1",
                "Terms of service",
                new Contact("Lucy Tech", "www.lucyqa.com", "lucyqa@techlead.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}