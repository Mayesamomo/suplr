package com.m.s;

import com.m.s.Models.Product;
import com.m.s.Models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;

@SpringBootApplication
@EntityScan("com.m.s.Models")
@EnableJpaRepositories("com.m.s.Repository")
public class SuplrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuplrApplication.class, args);
    }

}
