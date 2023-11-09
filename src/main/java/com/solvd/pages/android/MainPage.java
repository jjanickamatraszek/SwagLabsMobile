package com.solvd.pages.android;

import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @AndroidFindBy(accessibility = "test-PRODUCTS")
    private ExtendedWebElement itemsContainer;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/preceding-sibling::android.widget.ImageView")
    private ExtendedWebElement itemImageFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addItemToCartBtnFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeItemFromCartBtnFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-REMOVE' or @content-desc='test-ADD TO CART']")
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
        swipeToItem(itemTitle, Direction.UP);
        return itemTitleFormatted.format(itemTitle).isVisible(1);
    }

    @Override
    public MainPageBase addItemToCart(String itemTitle) {
        swipeToItem(itemTitle, Direction.UP);
        addItemToCartBtnFormatted.format(itemTitle).click();
        return this;
    }

    @Override
    public MainPageBase removeItemFromCart(String itemTitle) {
        swipeToItem(itemTitle, Direction.UP);
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
