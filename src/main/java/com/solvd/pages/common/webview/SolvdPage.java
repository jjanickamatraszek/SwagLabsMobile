package com.solvd.pages.common.webview;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SolvdPage extends AbstractPage {

    @FindBy(xpath = ".//nav[@aria-label='Main']//button")
    private ExtendedWebElement menuBtn;

    @FindBy(xpath = ".//nav[@aria-label='Main']/div[contains(@class, 'MuiBox-root')]")
    private ExtendedWebElement menu;

    public SolvdPage(WebDriver driver) {
        super(driver);
    }

    public SolvdPage clickMenuBtn() {
        menuBtn.click();
        return this;
    }

    public boolean isMenuExpanded() {
        return menu.isVisible(5);
    }
}
