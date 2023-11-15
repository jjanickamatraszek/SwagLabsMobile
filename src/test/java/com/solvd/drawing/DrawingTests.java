package com.solvd.drawing;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.DrawingPageBase;
import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DrawingTests extends SauceDemoBaseTest {

    @Test
    public void drawLineTest() {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        TopAppBarPageBase topBar = initPage(getDriver(), TopAppBarPageBase.class);
        DrawingPageBase drawingPage = topBar.clickMenuBtn()
                .navigateToDrawingPage();

        Assert.assertTrue(drawingPage.isPageOpened());

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(drawingPage.isDrawingPadVisibleByImage(),
                "Empty drawing pad is not visible");
        drawingPage.drawLine();
        soft.assertTrue(drawingPage.isLineDrawn(),
                "Image with line is not visible");
        soft.assertAll();
    }
}
