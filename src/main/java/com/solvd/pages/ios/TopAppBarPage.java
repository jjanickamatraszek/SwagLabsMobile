package com.solvd.pages.ios;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.solvd.utils.PageUtils;
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

    private PageUtils pageUtils;

    public TopAppBarPage(WebDriver driver) {
        super(driver);
        pageUtils = new PageUtils();
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
        pageUtils.tapRightBottomPartOfElement(cartIcon);
        return initPage(CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMenuBtn() {
        pageUtils.tapRightBottomPartOfElement(menuIcon);
        return initPage(MenuPageBase.class);
    }
}
