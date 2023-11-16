package com.solvd.drawing;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTests extends SauceDemoBaseTest {

    @Test
    public void drawLineTest() {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(getDriver(), TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage()
                .drawLine();
        Assert.assertTrue(drawingPage.isLineDrawn(),
                "Image with line is not visible");
        ;
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
}
