package com.solvd.pages.ios;

import com.solvd.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.awt.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    @ExtendedFindBy(iosPredicate = "name = 'Signature Pad demo'")
    private ExtendedWebElement signaturePad;

    @ExtendedFindBy(iosPredicate = "name = '{L10N:drawingPage.pageTitle.name}' AND type = 'XCUIElementTypeOther'")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(image = "images/ios/ios_line.png")
    private ExtendedWebElement expectedLineImage;

    @ExtendedFindBy(image = "images/ios/ios_house.png")
    private ExtendedWebElement expectedHouseImage;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return signaturePad.isPresent();
    }

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
        return expectedLineImage.isVisible(3);
    }

    @Override
    public DrawingPageBase drawHouse() {
        int x = signaturePad.getLocation().getX();
        int y = signaturePad.getLocation().getY();
        int fromX = x + 40;
        int fromY = y + 200;

        pageUtils.drawLine(fromX, fromY, fromX + 300, fromY);
        pageUtils.drawLine(fromX + 50, fromY + 200, fromX + 270, fromY + 200);
        pageUtils.drawLine(fromX + 50, fromY, fromX + 50, fromY + 220);
        pageUtils.drawLine(fromX + 250, fromY, fromX + 250, fromY + 220);
        pageUtils.drawLine(fromX, fromY, fromX + 175, fromY - 110);
        pageUtils.drawLine(fromX + 170, fromY - 100, fromX + 300, fromY);
        return this;
    }

    @Override
    public boolean isHouseDrawn() {
        pageUtils.setImageMatchThreshold(0.3);
        return expectedHouseImage.isVisible(3);
    }

    @Override
    public Color getPageTitleColorInCenter() {
        return pageUtils.getElementColorInCenter(pageTitle);
    }
}
