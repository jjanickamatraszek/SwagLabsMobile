package com.solvd.utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.time.Duration;
import java.util.List;

public class PageUtils implements ICustomTypePageFactory, IMobileUtils {

    public void setImageMatchThreshold(double value) {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, value);
    }

    public Color getElementColorInCenter(ExtendedWebElement element) {
        File scrFile = element.getElement().getScreenshotAs(OutputType.FILE);
        int centerX = element.getSize().getWidth() / 2;
        int centerY = element.getSize().getHeight() / 2;

        BufferedImage image = null;
        try {
            image = ImageIO.read(scrFile);
        } catch (IOException e) {
            throw new UncheckedIOException("Reading image of element failed", e);
        }

        int pixel = image.getRGB(centerX, centerY);
        return new Color(pixel);
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

    public void tapRightBottomPartOfElement(ExtendedWebElement el) {
        int width = el.getSize().getWidth();
        int height = el.getSize().getHeight();
        int x = el.getLocation().getX();
        int y = el.getLocation().getY();
        int movedX = (int) Math.round(x + width * 0.8);
        int movedY = (int) Math.round(y + height * 0.8);
        tap(movedX, movedY);
    }
}
