package com.solvd.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends AbstractPage {

    @FindBy(xpath = "//XCUIElementTypeAlert[@name='Open in “SwagLabsMobileApp”?']")
    private ExtendedWebElement popupContainer;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Open']")
    private ExtendedWebElement openBtn;

    public PopupPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(openBtn);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void clickOpenBtn() {
        openBtn.click();
    }
}
