package com.solvd.pages.ios;

import com.solvd.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == '{L10N:cartPage.pageTitle.name}'`]")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(iosPredicate = "name = '{L10N:cartPage.cartContent.name}'")
    private ExtendedWebElement itemsContainer;

    @ExtendedFindBy(iosPredicate = "name = 'test-Item'")
    private ExtendedWebElement itemContainer;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == '%s'`]")
    private ExtendedWebElement itemTitleFormatted;

    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
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
