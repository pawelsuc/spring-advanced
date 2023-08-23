package com.pawelsuc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringAdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }


}