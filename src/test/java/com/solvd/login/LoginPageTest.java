package com.solvd.login;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.dataProviders.DataProviders;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.MainPageBase;
import com.solvd.utils.LoginErrorMessages;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest implements IAbstractTest, IMobileUtils {

    @Test
    public void loginWithValidCredentialsTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        MainPageBase mainPage = loginPage.login();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened after login");
    }

    @Test(dataProvider = "passwords for empty username", dataProviderClass = DataProviders.class)
    public void displayErrorMessageWhenEmptyUsernameTest(String password) {
        String expectedErrorMessage = LoginErrorMessages.usernameRequired;

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typePassword(password);
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenEmptyPasswordTest() {
        String expectedErrorMessage = LoginErrorMessages.passwordRequired;

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(R.TESTDATA.get("username"));
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenInvalidUsernameTest() {
        String expectedErrorMessage = LoginErrorMessages.credsDontMatch;

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName("invalid");
        loginPage.typePassword(R.TESTDATA.get("password"));
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void displayErrorMessageWhenInvalidPasswordTest() {
        String expectedErrorMessage = LoginErrorMessages.credsDontMatch;

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(R.TESTDATA.get("username"));
        loginPage.typePassword("invalid");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage),
                "Error message is not displayed with expected text. Expected: '%s'. Actual: '%s'"
                        .formatted(expectedErrorMessage, loginPage.getErrorMessageText()));
    }

    @Test
    public void loginCorrectlyAfterFailedAttemptTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(R.TESTDATA.get("username"));
        loginPage.typePassword("invalid");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed after unsuccessful login");

        MainPageBase mainPage = loginPage.login();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened after failed attempt");
    }
}
