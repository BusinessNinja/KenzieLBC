package com.kenzie.appserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
@ComponentScan("com.kenzie.appserver")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
