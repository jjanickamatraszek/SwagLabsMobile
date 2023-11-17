package com.solvd.utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class PageUtils implements ICustomTypePageFactory {

    public void setImageMatchThreshold(double value) {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, value);
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
}
