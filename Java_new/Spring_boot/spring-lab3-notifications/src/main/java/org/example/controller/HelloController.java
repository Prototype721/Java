package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping ("/hello")
    public String sayHello() {
        return "Привет, Spring Boot !";
    }

    @GetMapping ("/goodbye")
    public String saybye() {
        return "До свидания, Spring Boot!";
    }

    @GetMapping ("/greet")
    public String greetSomeone(@RequestParam String name) {
        return "Привет, " + name + "!";
    }
}
