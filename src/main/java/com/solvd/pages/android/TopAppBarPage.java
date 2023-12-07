package com.solvd.pages.android;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TopAppBarPageBase.class)
public class TopAppBarPage extends TopAppBarPageBase {

    @ExtendedFindBy(image = "images/menu.png")
    private ExtendedWebElement menuIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:appBarPage.cartBtn.content-desc}']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:appBarPage.cartBtn.content-desc}']//android.widget.TextView")
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
        return initPage(CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMenuBtn() {
        menuIcon.click();
        return initPage(MenuPageBase.class);
    }
}
