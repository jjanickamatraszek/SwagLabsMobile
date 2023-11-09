package com.solvd.pages.android;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/..")
    private ExtendedWebElement topAppBar;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Cart Content']")
    private ExtendedWebElement itemsContainer;

    @AndroidFindBy(accessibility = "test-Item")
    private ExtendedWebElement itemContainer;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TopAppBarPageBase getTopAppBar() {
        return initPage(getDriver(), TopAppBarPageBase.class);
    }

    @Override
    public boolean isCartEmpty() {
        return !itemContainer.isVisible(1);
    }

    @Override
    public boolean swipeToItem(String itemTitle, Direction direction) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, direction, 20);
    }

    @Override
    public boolean swipeToItem(String itemTitle, Direction direction, int count) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, direction, count);
    }

    @Override
    public boolean isItemDisplayed(String itemTitle) {
        return swipeToItem(itemTitle, Direction.UP);
    }
}
