package com.solvd.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage implements IMobileUtils {

    protected DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDrawingPadVisibleByImage();

    public abstract void drawLine(int fromX, int fromY, int toX, int toY);

    public abstract DrawingPageBase drawLine();

    public abstract boolean isLineDrawn();
}
