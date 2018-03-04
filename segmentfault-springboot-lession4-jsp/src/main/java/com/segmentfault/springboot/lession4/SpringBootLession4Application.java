package com.segmentfault.springboot.lession4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.segmentfault.springboot.lession4.servlet"})
public class SpringBootLession4Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLession4Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootLession4Application.class);
    }

}
