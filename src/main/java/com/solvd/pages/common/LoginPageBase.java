package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends BaseSauceDemoPageBase {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void clickLoginBtn();

    public abstract boolean isErrorMessageDisplayed(String expectedErrorMessageText);

    public abstract boolean isErrorMessageDisplayed();

    public abstract String getErrorMessageText();
}
