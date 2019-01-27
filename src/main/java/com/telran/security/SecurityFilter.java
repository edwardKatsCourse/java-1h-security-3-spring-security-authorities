package com.telran.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityFilter extends OncePerRequestFilter {


    private static final String HEADER_NAME = "Authorization";

//    private static final String ADMIN_VALID_TOKEN = "admin_token";
//    private static final String REGULAR_VALID_TOKEN = "regular_valid_token";


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String headerData = httpServletRequest.getHeader(HEADER_NAME);

        if (headerData != null) {

            //Replace this part with a real Database request by "headerData" (token)
            User user = UserStorage.getUserByToken(headerData);
            if (user != null) {

                List<GrantedAuthority> roles = user.getRoles().stream()
//                        .map(x -> new SimpleGrantedAuthority("ROLE_" + x)) //ADMIN -> ROLE_ADMIN
                        .map(x -> new SimpleGrantedAuthority(x)) //ADMIN -> ADMIN
                        .collect(Collectors.toList());

                Authentication keyToPassValidator = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        /*   List<String>   ->    List<SimpleGrantedAuthority>      */
                        roles
                        );

                System.out.println("Authentication: ");
                System.out.println(keyToPassValidator);
                System.out.println();

                SecurityContextHolder.getContext().setAuthentication(keyToPassValidator);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
