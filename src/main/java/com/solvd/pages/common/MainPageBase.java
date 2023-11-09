package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase extends AbstractPage implements IMobileUtils {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TopAppBarPageBase getTopAppBar();

    public abstract boolean swipeToItem(String itemTitle, Direction direction);

    public abstract boolean isItemDisplayed(String itemTitle);

    public abstract MainPageBase addItemToCart(String itemTitle);

    public abstract MainPageBase removeItemFromCart(String itemTitle);

    public abstract boolean isAddToCartBtnForItemVisible(String itemTitle);

    public abstract boolean isRemoveBtnForItemVisible(String itemTitle);
}
