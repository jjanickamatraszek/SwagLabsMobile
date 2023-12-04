package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends BaseSauceDemoPageBase {

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartEmpty();

    public abstract boolean swipeToItemTitle(String itemTitle, Direction direction);

    public abstract boolean swipeToItemTitle(String itemTitle, Direction direction, int count);

    public abstract boolean isItemTitleDisplayed(String itemTitle);
}
