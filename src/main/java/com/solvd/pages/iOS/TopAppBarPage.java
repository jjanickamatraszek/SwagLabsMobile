package com.solvd.pages.iOS;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TopAppBarPageBase.class)
public class TopAppBarPage extends TopAppBarPageBase {

    @iOSXCUITFindBy(accessibility = "test-Menu")
    private ExtendedWebElement menuIcon;

    @iOSXCUITFindBy(accessibility = "test-Cart")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']/XCUIElementTypeOther[@name]")
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
        return Integer.parseInt(amountOfItemInCart.getAttribute("name"));
    }

    @Override
    public CartPageBase clickCartBtn() {
        tapRightBottomPartOfElement(cartIcon);
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMenuBtn() {
        tapRightBottomPartOfElement(menuIcon);
        return initPage(getDriver(), MenuPageBase.class);
    }

    private void tapRightBottomPartOfElement(ExtendedWebElement el) {
        int width = el.getSize().getWidth();
        int height = el.getSize().getHeight();
        int x = el.getLocation().getX();
        int y = el.getLocation().getY();
        int movedX = (int) Math.round(x + width * 0.8);
        int movedY = (int) Math.round(y + height * 0.8);
        tap(movedX, movedY);
    }
}
