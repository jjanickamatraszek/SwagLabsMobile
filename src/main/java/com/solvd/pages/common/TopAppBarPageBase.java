package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TopAppBarPageBase extends AbstractPage implements IMobileUtils {

    public TopAppBarPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isItemsAmountVisible();

    public abstract int getItemsAmountInCart();

    public abstract CartPageBase clickCartBtn();
}
