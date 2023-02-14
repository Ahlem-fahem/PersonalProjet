package com.example.worldtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WorldTourApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldTourApplication.class, args);
    }
}
