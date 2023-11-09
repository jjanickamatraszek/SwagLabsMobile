package com.solvd.pages.iOS;

import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @iOSXCUITFindBy(accessibility = "test-PRODUCTS")
    private ExtendedWebElement itemsContainer;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title' and @text='%s']/preceding-sibling::XCUIElementTypeOther[@name]")
    private ExtendedWebElement itemImageFormatted;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-ADD TO CART']")
    private ExtendedWebElement addItemToCartBtnFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-REMOVE']")
    private ExtendedWebElement removeItemFromCartBtnFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-REMOVE' or @name='test-ADD TO CART']")
    private ExtendedWebElement addRemoveBtnContainerFormatted;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemsContainer.isElementPresent();
    }

    @Override
    public TopAppBarPageBase getTopAppBar() {
        return initPage(getDriver(), TopAppBarPageBase.class);
    }

    @Override
    public boolean swipeToItem(String itemTitle, Direction direction) {
        switch (direction) {
            case UP -> {
                return swipe(addRemoveBtnContainerFormatted.format(itemTitle), itemsContainer, Direction.UP, 10);
            }
            case DOWN -> {
                return swipe(itemImageFormatted.format(itemTitle), itemsContainer, Direction.DOWN, 10);
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean isItemDisplayed(String itemTitle) {
        return swipeToItem(itemTitle, Direction.UP);
    }

    @Override
    public void addItemToCart(String itemTitle) {
        swipeToItem(itemTitle, Direction.UP);
        addItemToCartBtnFormatted.format(itemTitle).click();
    }

    @Override
    public void removeItemFromCart(String itemTitle) {
        swipeToItem(itemTitle, Direction.UP);
        removeItemFromCartBtnFormatted.format(itemTitle).click();
    }

    @Override
    public boolean isAddToCartBtnForItemVisible(String itemTitle) {
        return addItemToCartBtnFormatted.format(itemTitle).isVisible();
    }

    @Override
    public boolean isRemoveBtnForItemVisible(String itemTitle) {
        return removeItemFromCartBtnFormatted.format(itemTitle).isVisible();
    }
}
