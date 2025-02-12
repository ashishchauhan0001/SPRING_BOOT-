package com.ashish.introToSB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

//    it is an API end Point localhost:8080/hello

    @GetMapping("hello")
    public String sayHello() {
        return "Hello from Spring Boot! ";
    }
}
