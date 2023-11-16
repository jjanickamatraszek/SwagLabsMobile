package com.solvd.pages.android;

import com.solvd.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    @FindBy(xpath = "//android.view.View[@resource-id='signature-pad']//android.widget.Image")
    private ExtendedWebElement signaturePad;

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

        drawLine(fromX, fromY, toX, toY);
        return this;
    }

    public void drawLine(int fromX, int fromY, int toX, int toY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0L), PointerInput.Origin.viewport(), fromX, fromY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, Duration.ofMillis(1000L)));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000L), PointerInput.Origin.viewport(), toX, toY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        Interactive drv = null;

        try {
            drv = (Interactive) this.getDriver();
            drv.perform(List.of(sequence));
        } catch (ClassCastException e) {
            throw new UnsupportedOperationException("Driver doesn't support drawing method", e);
        }
    }

    @Override
    public boolean isLineDrawn() {
        setImageMatchThreshold(0.3);
        return expectedLineImage.isPresent(3);
    }

    @Override
    public DrawingPageBase drawHouse() {
        int x = signaturePad.getLocation().getX();
        int y = signaturePad.getLocation().getY();
        int fromX = x + 200;
        int fromY = y + 400;

        drawLine(fromX, fromY, fromX + 330, fromY);
        drawLine(fromX + 50, fromY + 200, fromX + 270, fromY + 200);
        drawLine(fromX + 50, fromY, fromX + 50, fromY + 220);
        drawLine(fromX + 250, fromY, fromX + 250, fromY + 220);
        drawLine(fromX, fromY, fromX + 180, fromY - 120);
        drawLine(fromX + 170, fromY - 100, fromX + 330, fromY);
        return this;
    }

    @Override
    public boolean isHouseDrawn() {
        setImageMatchThreshold(0.3);
        return expectedHouseImage.isPresent(3);
    }

    private void setImageMatchThreshold(double value) {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, value);
    }
}
