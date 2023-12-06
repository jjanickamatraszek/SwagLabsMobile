package com.solvd.pages.ios;

import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @Localized
    @ExtendedFindBy(iosPredicate = "name = '{L10N:menuPage.allItems.name}'")
    private ExtendedWebElement allItemsLink;

    @Localized
    @ExtendedFindBy(iosPredicate = "name = '{L10N:menuPage.webView.name}'")
    private ExtendedWebElement webViewLink;

    @Localized
    @ExtendedFindBy(iosPredicate = "name = '{L10N:menuPage.geolocation.name}'")
    private ExtendedWebElement geolocationLink;

    @Localized
    @ExtendedFindBy(iosPredicate = "name = '{L10N:menuPage.drawing.name}'")
    private ExtendedWebElement drawingLink;

    public MenuPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingLink);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public DrawingPageBase navigateToDrawingPage() {
        drawingLink.click();
        return initPage(DrawingPageBase.class);
    }

    @Override
    public void hoverAllItemsLink() {
        allItemsLink.hover();
    }

    @Override
    public void hoverWebViewLink() {
        webViewLink.hover();
    }

    @Override
    public void hoverGeolocationLink() {
        geolocationLink.hover();
    }

    @Override
    public void hoverDrawingLink() {
        drawingLink.hover();
    }
}
