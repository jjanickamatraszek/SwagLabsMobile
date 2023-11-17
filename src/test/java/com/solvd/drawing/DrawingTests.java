package com.solvd.drawing;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.solvd.utils.ImageColor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class DrawingTests extends SauceDemoBaseTest {

    @Test
    public void drawLineTest() {
        authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(getDriver(), TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage()
                .drawLine();
        Assert.assertTrue(drawingPage.isLineDrawn(),
                "Image with line is not visible");
    }

    @Test
    public void drawHouseTest() {
        authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(getDriver(), TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage()
                .drawHouse();
        Assert.assertTrue(drawingPage.isHouseDrawn(),
                "Image with house is not visible");
    }

    @Test
    public void verifyPageTitleColorInCenterTest() {
        authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(getDriver(), TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage();
        Color actualPageTitleColor = drawingPage.getPageTitleColorInCenter();
        Assert.assertEquals(actualPageTitleColor, ImageColor.GREY.getRGB(),
                "Color of page title image in central pixel is different than expected");
    }
}
