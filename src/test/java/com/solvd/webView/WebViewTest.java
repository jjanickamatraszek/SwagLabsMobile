package com.solvd.webView;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.TopAppBarPageBase;
import com.solvd.pages.common.WebViewPageBase;
import com.solvd.pages.common.webview.SolvdPage;
import com.solvd.utils.MobileContextUtils;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTest extends SauceDemoBaseTest {

    @Test
    @TestCaseKey(value = "JOANNA-45")
    public void switchContextToWebViewTest() {
        authUtils.loginWithDefaultUser();
        WebViewPageBase webViewPage = initPage(TopAppBarPageBase.class)
                .clickMenuBtn()
                .navigateToWebViewPage();
        webViewPage.enterUrlInSearchField("https://www.solvd.com")
                .clickGoToSiteBtn();
        webViewPage.waitForLoadingFinish();

        (new MobileContextUtils()).switchMobileContext(MobileContextUtils.View.WEB_SWAG_LABS);

        SolvdPage solvedPage = new SolvdPage(getDriver());
        solvedPage.clickMenuBtn();
        Assert.assertTrue(solvedPage.isMenuExpanded(), "After switching to web view context and clicking on menu btn, menu didn't expand");
    }
}
