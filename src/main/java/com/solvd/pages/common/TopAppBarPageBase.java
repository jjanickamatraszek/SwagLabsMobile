package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class TopAppBarPageBase extends BaseSauceDemoPageBase {

    public TopAppBarPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isItemsAmountVisible();

    public abstract int getItemsAmountInCart();

    public abstract CartPageBase clickCartBtn();

    public abstract MenuPageBase clickMenuBtn();
}
