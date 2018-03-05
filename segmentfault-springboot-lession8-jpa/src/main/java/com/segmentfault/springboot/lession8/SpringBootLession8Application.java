package com.segmentfault.springboot.lession8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class SpringBootLession8Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLession8Application.class, args);
    }
}
