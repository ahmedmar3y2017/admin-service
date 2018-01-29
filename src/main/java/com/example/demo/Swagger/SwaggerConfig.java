//package com.example.demo.Swagger;
//
///**
// * Created by ahmed on 1/27/2018.
// */
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.WebService"))
//                .paths(PathSelectors.regex("/rest.*")).build().apiInfo(metaData());
//
//    }
//    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfo(
//                "BusinessIn Admin with Spring Boot REST API",
//                "Spring Boot REST API for BusinessIn Admin",
//                "2.0",
//                "Terms of service",
//                new Contact("ahmed mar3y", "https://www.linkedin.com/in/ahmed-mar3y-58b834a3/", "ahmedmar3y108@gmail.com"),
//                "buinessIn Admin Api License Version 0",
//                "None url ");
//        return apiInfo;
//    }
//
//}
