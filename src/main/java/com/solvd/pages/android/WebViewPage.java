package com.solvd.pages.android;

import com.solvd.pages.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//android.widget.EditText")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='{L10N:webViewPage.goToSiteBtn.content-desc}']")
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
