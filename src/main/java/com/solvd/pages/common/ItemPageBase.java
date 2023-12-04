package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class ItemPageBase extends BaseSauceDemoPageBase {

    protected ItemPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();
}
