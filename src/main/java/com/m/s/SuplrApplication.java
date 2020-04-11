package com.m.s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.m.s.Models")
@EnableJpaRepositories("com.m.s.Repository")
public class SuplrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuplrApplication.class, args);

    }

}
