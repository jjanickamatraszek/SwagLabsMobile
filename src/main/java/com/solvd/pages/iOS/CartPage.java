package com.solvd.pages.iOS;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
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

    public TopAppBarPageBase getTopAppBar() {
        return initPage(getDriver(), TopAppBarPageBase.class);
    }

    @Override
    public boolean isCartEmpty() {
        return !itemContainer.isVisible(1);
    }

    @Override
    public boolean swipeDownToItem(String itemTitle) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, Direction.DOWN, 20);
    }

    @Override
    public boolean swipeUpToItem(String itemTitle) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, Direction.UP, 20);
    }

    @Override
    public boolean swipeUpToItem(String itemTitle, int count) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, Direction.UP, count);
    }
}
