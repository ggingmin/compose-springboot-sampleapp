package com.sample.springbootsampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootSampleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleAppApplication.class, args);
    }

}
