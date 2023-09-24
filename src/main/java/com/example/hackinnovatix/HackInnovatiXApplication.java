package com.example.hackinnovatix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HackInnovatiXApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackInnovatiXApplication.class, args);
    }
}
