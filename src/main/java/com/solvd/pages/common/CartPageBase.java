package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage implements IMobileUtils {

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getAmountOfItemsInCart();

    public abstract boolean swipeDownToItem(String itemTitle);

    public abstract boolean swipeUpToItem(String itemTitle);
}
