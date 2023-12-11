package com.solvd.pages.ios;

import com.solvd.pages.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField")
    private ExtendedWebElement searchTextField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == '{L10N:webViewPage.goToSiteBtn.name}'`]")
    private ExtendedWebElement goToSiteBtn;

    @ExtendedFindBy(image = "images/loadingImage.png")
    private ExtendedWebElement loadingImage;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebViewPageBase enterUrlInSearchField(String url) {
        waitUntil(ExpectedConditions.visibilityOf(searchTextField.getElement()), 3);
        searchTextField.type(url);
        return this;
    }

    @Override
    public void clickGoToSiteBtn() {
        goToSiteBtn.click();
    }

    @Override
    public void waitForLoadingFinish() {
        pageUtils.setImageMatchThreshold(0.3);
        if (loadingImage.isPresent()) {
            waitUntil(ExpectedConditions.invisibilityOf(loadingImage.getElement()), 5);
        }
    }
}
