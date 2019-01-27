package com.telran.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/regular") //role -> REGULAR or ADMIN
    public String regularUser(@AuthenticationPrincipal User user) {

        return String.format("/regular was called by user: %s %s",
                user.getFirstName(),
                user.getLastName()
        );
    }


    @GetMapping("/admin") //role -> ADMIN
    public String adminUser(@AuthenticationPrincipal User user) {
        return String.format("/admin was called by user: %s %s",
                user.getFirstName(),
                user.getLastName()
        );
    }
}
