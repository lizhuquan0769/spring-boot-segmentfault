package com.segmentfault.springboot.lession8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootLession8Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLession8Application.class, args);
    }
}
