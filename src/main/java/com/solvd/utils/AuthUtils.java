package com.solvd.utils;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.MainPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthUtils implements ICustomTypePageFactory {

    private void inputLoginCredentials(String username, String password) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.clickLoginBtn();
    }

    public LoginPageBase login(String username, String password) {
        inputLoginCredentials(username, password);
        return initPage(getDriver(), LoginPageBase.class);
    }

    public MainPageBase loginWithDefaultUser() {
        inputLoginCredentials(R.TESTDATA.get("username"), R.TESTDATA.get("password"));
        return initPage(getDriver(), MainPageBase.class);
    }
}
