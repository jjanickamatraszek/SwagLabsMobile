package com.solvd.pages.ios.browser;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SafariStartPage extends AbstractPage {

    @FindBy(xpath = "//XCUIElementTypeOther[contains(@name,'CapsuleNavigationBar')]")
    private ExtendedWebElement addressField;

    @iOSXCUITFindBy(accessibility = "Go")
    private ExtendedWebElement goKey;

    public SafariStartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(addressField);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void typeDeepLink(String deepLink) {
        addressField.type(deepLink);
    }

    public void clickGoKey() {
        goKey.click();
    }
}
