package com.solvd.utils;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.MainPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthUtils implements ICustomTypePageFactory {

    public void login(String username, String password) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.clickLoginBtn();
    }

    public MainPageBase loginWithDefaultUser() {
        login(R.TESTDATA.get("username"), R.TESTDATA.get("password"));
        return initPage(MainPageBase.class);
    }
}
