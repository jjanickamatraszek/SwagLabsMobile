package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ItemPageBase extends AbstractPage implements IMobileUtils {

    protected ItemPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();
}
