package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends BaseSauceDemoPageBase {
    protected MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DrawingPageBase navigateToDrawingPage();

    public abstract WebViewPageBase navigateToWebViewPage();

    public abstract void hoverAllItemsLink();

    public abstract void hoverWebViewLink();

    public abstract void hoverGeolocationLink();

    public abstract void hoverDrawingLink();
}
