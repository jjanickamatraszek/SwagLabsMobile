package com.solvd.pages.ios;

import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(iosPredicate = "name = '{L10N:menuPage.drawing.name}'")
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
