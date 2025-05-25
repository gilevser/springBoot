package ru.netology.springBoot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ConfigurationProperties("hello") //префикс для всех свойств берем из application.properties
public class HelloController {
    @Value("${hello.name:undefined}")
    private String name;

//    для @ConfigurationProperties
//    public void setName(String name) {
//        this.name = name;
//    }

    @GetMapping("/hello")
    private String hello() {
        return String.format("Hello %s!",name);
    }
    //Invoke-WebRequest -Uri "http://localhost:8080/" -Verbose
    //Invoke-WebRequest -Uri "http://localhost:8080/actuator/health" -Verbose
    //Invoke-WebRequest -Uri "http://localhost:8888/" -Verbose

}
