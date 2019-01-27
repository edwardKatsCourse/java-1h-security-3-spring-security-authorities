package com.telran.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/free-access")
public class AnotherController {

    @GetMapping("/method-1")
    public String getMethod1() {
        return "method 1";
    }

//    @Secured("ROLE_REGULAR")
    @PreAuthorize("hasAuthority('REGULAR')")
    @GetMapping("/method-2")
    public String getMethod2() {
        return "method 2";
    }
}
