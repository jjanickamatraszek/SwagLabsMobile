package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage implements IMobileUtils {

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartEmpty();

    public abstract boolean swipeToItemTitle(String itemTitle, Direction direction);

    public abstract boolean swipeToItemTitle(String itemTitle, Direction direction, int count);

    public abstract boolean isItemTitleDisplayed(String itemTitle);
}
