package com.solvd.pages.android;

import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @AndroidFindBy(accessibility = "test-DRAWING")
    private ExtendedWebElement drawingLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DrawingPageBase navigateToDrawingPage() {
        drawingLink.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }
}
