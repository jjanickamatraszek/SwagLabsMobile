package com.solvd.utils;

public enum LoginErrorMessage {
    USERNAME_REQUIRED("Username is required"),
    PASSWORD_REQUIRED("Password is required"),
    CREDS_DONT_MATCH("Username and password do not match any user in this service.");

    private String desc;

    LoginErrorMessage(String desc) {
        this.desc = desc;
    }

    public String get() {
        return desc;
    }
}
