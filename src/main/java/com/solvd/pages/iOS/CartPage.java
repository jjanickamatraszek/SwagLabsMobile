package com.solvd.pages.iOS;

import com.solvd.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer]")
    private ExtendedWebElement topAppBar;

    @iOSXCUITFindBy(accessibility = "test-Cart Content")
    private ExtendedWebElement itemsContainer;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item]")
    private ExtendedWebElement itemContainer;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCartEmpty() {
        return !itemContainer.isVisible(1);
    }

    @Override
    public boolean swipeToItemTitle(String itemTitle, Direction direction) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, direction, 20);
    }

    @Override
    public boolean swipeToItemTitle(String itemTitle, Direction direction, int count) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, direction, count);
    }

    @Override
    public boolean isItemTitleDisplayed(String itemTitle) {
        return swipeToItemTitle(itemTitle, Direction.UP);
    }
}
