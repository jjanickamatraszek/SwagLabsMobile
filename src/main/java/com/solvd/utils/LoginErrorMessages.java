package com.solvd.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginErrorMessages {
    public static final String usernameRequired = "Username is required";
    public static final String passwordRequired = "Password is required";
    public static final String credsDontMatch = "Username and password do not match any user in this service.";
}
