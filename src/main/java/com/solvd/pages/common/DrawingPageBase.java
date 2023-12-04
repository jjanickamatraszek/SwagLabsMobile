package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

import java.awt.*;

public abstract class DrawingPageBase extends BaseSauceDemoPageBase {

    protected DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DrawingPageBase drawLine();

    public abstract boolean isLineDrawn();

    public abstract DrawingPageBase drawHouse();

    public abstract boolean isHouseDrawn();

    public abstract Color getPageTitleColorInCenter();
}
