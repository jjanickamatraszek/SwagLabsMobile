package com.solvd.pages.android;

import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:menuPage.drawing.content-desc}']")
    private ExtendedWebElement drawingLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DrawingPageBase navigateToDrawingPage() {
        drawingLink.click();
        return initPage(DrawingPageBase.class);
    }
}
