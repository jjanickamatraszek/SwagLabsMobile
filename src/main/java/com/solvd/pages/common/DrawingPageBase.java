package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public abstract class DrawingPageBase extends AbstractPage implements IMobileUtils {

    protected DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DrawingPageBase drawLine();

    public abstract boolean isLineDrawn();

    public abstract DrawingPageBase drawHouse();

    public abstract boolean isHouseDrawn();

    public abstract Color getPageTitleColorInCenter();
}
