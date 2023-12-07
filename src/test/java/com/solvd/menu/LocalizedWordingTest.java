package com.solvd.menu;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.MenuPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.Test;

public class LocalizedWordingTest extends SauceDemoBaseTest {

    @Test
    @TestCaseKey({"JOANNA-44"})
    public void verifyMenuLinksTranslationsTest() {
        authUtils.loginWithDefaultUser();
        MenuPageBase menuPage = initPage(TopAppBarPageBase.class).clickMenuBtn();
        menuPage.hoverAllItemsLink();
        menuPage.hoverWebViewLink();
        menuPage.hoverGeolocationLink();
        menuPage.hoverDrawingLink();
        L10N.assertAll();
    }
}
