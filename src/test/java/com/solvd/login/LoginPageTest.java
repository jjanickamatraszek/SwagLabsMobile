package com.solvd.login;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.dataProviders.DataProviders;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.MainPageBase;
import com.solvd.utils.AuthUtils;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.solvd.utils.LoginErrorMessage.*;

public class LoginPageTest implements IAbstractTest, IMobileUtils {

    @Test
    public void loginWithValidCredentialsTest() {
        AuthUtils authUtils = new AuthUtils();
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened after login");
    }

    @Test(dataProvider = "passwords for empty username", dataProviderClass = DataProviders.class)
    public void displayErrorMessageWhenEmptyUsernameTest(String password) {
        String expectedErrorMessage = USERNAME_REQUIRED.get();

        AuthUtils authUtils = new AuthUtils();
        LoginPageBase loginPage = authUtils.login("", password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenEmptyPasswordTest() {
        String expectedErrorMessage = PASSWORD_REQUIRED.get();

        AuthUtils authUtils = new AuthUtils();
        LoginPageBase loginPage = authUtils.login(R.TESTDATA.get("username"), "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenInvalidUsernameTest() {
        String expectedErrorMessage = CREDS_DONT_MATCH.get();

        AuthUtils authUtils = new AuthUtils();
        LoginPageBase loginPage = authUtils.login("invalid", R.TESTDATA.get("password"));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenInvalidPasswordTest() {
        String expectedErrorMessage = CREDS_DONT_MATCH.get();

        AuthUtils authUtils = new AuthUtils();
        LoginPageBase loginPage = authUtils.login(R.TESTDATA.get("username"), "invalid");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void loginCorrectlyAfterFailedAttemptTest() {
        AuthUtils authUtils = new AuthUtils();
        LoginPageBase loginPage = authUtils.login(R.TESTDATA.get("username"), "invalid");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed after unsuccessful login");

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened after failed attempt");
    }
}
