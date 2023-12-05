package com.solvd.utils;

import com.zebrunner.carina.utils.resources.L10N;

public enum LoginErrorMessage {
    USERNAME_REQUIRED(L10N.getText("loginErrorMessage.usernameRequired")),
    PASSWORD_REQUIRED(L10N.getText("loginErrorMessage.passwordRequired")),
    CREDS_DONT_MATCH(L10N.getText("loginErrorMessage.credDontMatch"));

    private String desc;

    LoginErrorMessage(String desc) {
        this.desc = desc;
    }

    public String get() {
        return desc;
    }
}
