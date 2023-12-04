package com.solvd.pages.common;

import com.solvd.utils.PageUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class BaseSauceDemoPageBase extends AbstractPage implements IMobileUtils {

    protected final PageUtils pageUtils;

    protected BaseSauceDemoPageBase(WebDriver driver) {
        super(driver);
        pageUtils = new PageUtils();
    }
}
