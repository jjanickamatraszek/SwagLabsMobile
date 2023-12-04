package com.solvd.pages.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class PopupPage extends AbstractPage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeAlert[`name=='Open in “SwagLabsMobileApp”?'`]")
    private ExtendedWebElement popupContainer;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name=='Open'`]")
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
