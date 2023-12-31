package com.solvd.pages.android;

import com.solvd.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    @FindBy(xpath = "//android.view.View[@resource-id='signature-pad']//android.widget.Image")
    private ExtendedWebElement signaturePad;

    @FindBy(xpath = "//android.view.ViewGroup[./android.widget.TextView[@text='{L10N:drawingPage.title.text}']]")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(image = "images/android/android_line.png")
    private ExtendedWebElement expectedLineImage;

    @ExtendedFindBy(image = "images/android/android_house.png")
    private ExtendedWebElement expectedHouseImage;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return signaturePad.isVisible();
    }

    @Override
    public DrawingPageBase drawLine() {
        int x = signaturePad.getLocation().getX();
        int y = signaturePad.getLocation().getY();
        int fromX = x + 100;
        int fromY = y + 100;
        int toX = fromX + 200;
        int toY = fromY + 200;

        pageUtils.drawLine(fromX, fromY, toX, toY);
        return this;
    }

    @Override
    public boolean isLineDrawn() {
        pageUtils.setImageMatchThreshold(0.3);
        return expectedLineImage.isPresent(3);
    }

    @Override
    public DrawingPageBase drawHouse() {
        int x = signaturePad.getLocation().getX();
        int y = signaturePad.getLocation().getY();
        int fromX = x + 200;
        int fromY = y + 400;

        pageUtils.drawLine(fromX, fromY, fromX + 330, fromY);
        pageUtils.drawLine(fromX + 50, fromY + 200, fromX + 270, fromY + 200);
        pageUtils.drawLine(fromX + 50, fromY, fromX + 50, fromY + 220);
        pageUtils.drawLine(fromX + 250, fromY, fromX + 250, fromY + 220);
        pageUtils.drawLine(fromX, fromY, fromX + 180, fromY - 120);
        pageUtils.drawLine(fromX + 170, fromY - 100, fromX + 330, fromY);
        return this;
    }

    @Override
    public boolean isHouseDrawn() {
        pageUtils.setImageMatchThreshold(0.3);
        return expectedHouseImage.isPresent(3);
    }

    @Override
    public Color getPageTitleColorInCenter() {
        return pageUtils.getElementColorInCenter(pageTitle);
    }
}
