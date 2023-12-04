package com.solvd.drawing;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.solvd.utils.ImageColor;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class DrawingTests extends SauceDemoBaseTest {

    @Test
    @TestCaseKey({"JOANNA-38"})
    public void drawLineTest() {
        authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage()
                .drawLine();
        Assert.assertTrue(drawingPage.isLineDrawn(),
                "Image with line is not visible");
    }

    @Test
    @TestCaseKey({"JOANNA-39"})
    public void drawHouseTest() {
        authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage()
                .drawHouse();
        Assert.assertTrue(drawingPage.isHouseDrawn(),
                "Image with house is not visible");
    }

    @Test
    @TestCaseKey({"JOANNA-40"})
    public void verifyPageTitleColorInCenterTest() {
        authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage();
        Color actualPageTitleColor = drawingPage.getPageTitleColorInCenter();
        Assert.assertEquals(actualPageTitleColor, ImageColor.GREY.getRGB(),
                "Color of page title image in central pixel is different than expected");
    }
}
