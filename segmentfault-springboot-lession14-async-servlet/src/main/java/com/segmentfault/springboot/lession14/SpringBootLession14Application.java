package com.segmentfault.springboot.lession14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by lizhuquan on 2018/3/13.
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.segmentfault.springboot.lession14.servlet"})
public class SpringBootLession14Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLession14Application.class, args);
    }
}
