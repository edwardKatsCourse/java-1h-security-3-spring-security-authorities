package com.telran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Security3Java1hApplication {

    public static void main(String[] args) {
        SpringApplication.run(Security3Java1hApplication.class, args);
    }

}

