package org.example.healthcare_s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HealthCareSApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCareSApplication.class, args);
    }

}
