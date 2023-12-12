package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends BaseSauceDemoPageBase {

    protected WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase enterUrlInSearchField(String url);

    public abstract void clickGoToSiteBtn();

    public abstract void waitForLoadingFinish();
}
