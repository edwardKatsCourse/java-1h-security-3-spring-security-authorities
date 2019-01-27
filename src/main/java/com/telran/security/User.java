package com.telran.security;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {

    private Integer id;
    private String firstName;
    private String lastName;

    private List<String> roles;
}
