package com.solvd.pages.iOS;

import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @iOSXCUITFindBy(accessibility = "test-PRODUCTS")
    private ExtendedWebElement itemsContainer;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemsContainer.isElementPresent();
    }

    @Override
    public TopAppBarPageBase getTopAppBar() {
        return null;
    }

    @Override
    public boolean swipeDownToItem(String itemTitle) {
        return false;
    }

    @Override
    public boolean swipeUpToItem(String itemTitle) {
        return false;
    }

    @Override
    public boolean isItemVisible(String itemTitle) {
        return false;
    }

    @Override
    public void addItemToCart(String itemTitle) {

    }

    @Override
    public boolean isRemoveBtnForItemVisible(String itemTitle) {
        return false;
    }
}
