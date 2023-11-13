package com.solvd.pages.android;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TopAppBarPageBase.class)
public class TopAppBarPage extends TopAppBarPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement menuIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
    private ExtendedWebElement amountOfItemInCart;

    public TopAppBarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isItemsAmountVisible() {
        return amountOfItemInCart.isVisible(1);
    }

    @Override
    public int getItemsAmountInCart() {
        return Integer.parseInt(amountOfItemInCart.getText());
    }

    @Override
    public CartPageBase clickCartBtn() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}
