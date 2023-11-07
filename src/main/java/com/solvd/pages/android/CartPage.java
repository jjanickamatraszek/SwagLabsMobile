package com.solvd.pages.android;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/..")
    private ExtendedWebElement topAppBar;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Cart Content']")
    private ExtendedWebElement itemsContainer;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement itemTitle;

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public TopAppBarPageBase getTopAppBar() {
        return initPage(getDriver(), TopAppBarPageBase.class);
    }

    public int getAmountOfItemsInCart() {
        Set<String> items = new HashSet<>();
        do {
            items.add(itemTitle.getText());
        } while (!swipe(checkoutBtn, 1, 1000));
        return items.size();
    }

    public boolean swipeDownToItem(String itemTitle) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, Direction.DOWN, 20);
    }

    public boolean swipeUpToItem(String itemTitle) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, Direction.UP, 20);
    }
}
