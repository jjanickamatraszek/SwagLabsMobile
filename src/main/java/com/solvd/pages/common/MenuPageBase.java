package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {
    protected MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DrawingPageBase navigateToDrawingPage();
}
