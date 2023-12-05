package com.solvd.pages.ios;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(iosPredicate = "name = '{L10N:loginPage.username.name}'")
    private ExtendedWebElement usernameInputField;

    @ExtendedFindBy(iosPredicate = "name = '{L10N:loginPage.password.name}'")
    private ExtendedWebElement passwordInputField;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name CONTAINS[cd] 'test-Error'`]/XCUIElementTypeStaticText")
    private ExtendedWebElement errorMessageText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        usernameInputField.type(name);
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void clickLoginBtn() {
        loginBtn.click();
    }

    @Override
    public boolean isErrorMessageDisplayed(String expectedErrorMessageText) {
        return isElementWithTextPresent(errorMessageText, expectedErrorMessageText);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return errorMessageText.isElementPresent();
    }

    @Override
    public String getErrorMessageText() {
        return errorMessageText.getText();
    }
}
