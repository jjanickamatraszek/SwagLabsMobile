package com.solvd.pages.android;

import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @Localized
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:menuPage.allItems.content-desc}']/android.widget.TextView")
    private ExtendedWebElement allItemsLink;

    @Localized
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:menuPage.webView.content-desc}']/android.widget.TextView")
    private ExtendedWebElement webViewLink;

    @Localized
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:menuPage.geolocation.content-desc}']/android.widget.TextView")
    private ExtendedWebElement geolocationLink;

    @Localized
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:menuPage.drawing.content-desc}']/android.widget.TextView")
    private ExtendedWebElement drawingLink;

    public MenuPage(WebDriver driver) {
        super(driver);
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
