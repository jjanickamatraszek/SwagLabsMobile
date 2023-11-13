package com.solvd.pages.iOS;

import com.solvd.pages.common.MainPageBase;
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

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-Drag Handle']")
    private ExtendedWebElement itemDragHandleFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-REMOVE' or @name='test-ADD TO CART']")
    private ExtendedWebElement addRemoveBtnContainerFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart drop zone']")
    private ExtendedWebElement dropArea;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemsContainer.isElementPresent();
    }

    @Override
    public boolean swipeToItemTitle(String itemTitle, Direction direction) {
        return swipe(itemImageFormatted.format(itemTitle), itemsContainer, direction, 10);
    }

    @Override
    public boolean swipeToAddRemoveFromCartBtn(String itemTitle, Direction direction) {
        return swipe(addRemoveBtnContainerFormatted.format(itemTitle), itemsContainer, direction, 10);
    }

    @Override
    public boolean isItemTitleDisplayed(String itemTitle) {
        return swipeToItemTitle(itemTitle, Direction.UP);
    }

    @Override
    public MainPageBase clickAddToCartBtn(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        addItemToCartBtnFormatted.format(itemTitle).click();
        return this;
    }

    @Override
    public MainPageBase addItemToCartByDragAndDrop(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        dragAndDrop(itemDragHandleFormatted.format(itemTitle), dropArea);
        return this;
    }

    @Override
    public MainPageBase clickRemoveItemFromCartBtn(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        removeItemFromCartBtnFormatted.format(itemTitle).click();
        return this;
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
