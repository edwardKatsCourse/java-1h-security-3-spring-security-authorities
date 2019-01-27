package com.telran.security;

import java.util.*;

public class UserStorage {

    private static final User REGULAR_USER = User.builder()
            .firstName("David")
            .lastName("Regular")
            .roles(Arrays.asList("REGULAR"))
            .build();

    private static final User ADMIN_USER = User.builder()
            .firstName("John")
            .lastName("Admin")
            .roles(Arrays.asList("REGULAR", "ADMIN"))
            .build();

    private static final Map<String, User> userSession = new HashMap<String, User>() {{
        put("admin_user", ADMIN_USER);
        put("regular_user", REGULAR_USER);
    }};

    List<String> a = new ArrayList<String>();

    public static User getUserByToken(String token) {
        return userSession.get(token);
    }
}
