package com.segmentfault.springboot.lession1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootLession1Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootLession1Application.class, args);
    }

    @GetMapping
    public String helloword() {
        return "Hello World";
    }
}
