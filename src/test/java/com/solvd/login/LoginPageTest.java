package com.solvd.login;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.dataProviders.DataProviders;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.MainPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.solvd.utils.LoginErrorMessage.*;

public class LoginPageTest extends SauceDemoBaseTest {

    @Test
    public void loginWithValidCredentialsTest() {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened after login");
    }

    @Test(dataProvider = "passwords for empty username", dataProviderClass = DataProviders.class)
    public void displayErrorMessageWhenEmptyUsernameTest(String password) {
        String expectedErrorMessage = USERNAME_REQUIRED.get();

        authUtils.login("", password);
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenEmptyPasswordTest() {
        String expectedErrorMessage = PASSWORD_REQUIRED.get();

        authUtils.login(R.TESTDATA.get("username"), "");
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenInvalidUsernameTest() {
        String expectedErrorMessage = CREDS_DONT_MATCH.get();

        authUtils.login("invalid", R.TESTDATA.get("password"));
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenInvalidPasswordTest() {
        String expectedErrorMessage = CREDS_DONT_MATCH.get();

        authUtils.login(R.TESTDATA.get("username"), "invalid");
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void loginCorrectlyAfterFailedAttemptTest() {
        authUtils.login(R.TESTDATA.get("username"), "invalid");
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed after unsuccessful login");

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened after failed attempt");
    }
}
