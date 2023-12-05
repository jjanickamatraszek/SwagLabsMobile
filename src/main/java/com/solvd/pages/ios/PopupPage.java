package com.solvd.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class PopupPage extends AbstractPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeAlert[`name == '{L10N:deepLink.popup.container.name}'`]")
    private ExtendedWebElement popupContainer;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == '{L10N:deepLink.popup.openBtn.name}'`]")
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
