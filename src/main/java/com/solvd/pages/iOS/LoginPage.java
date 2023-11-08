package com.solvd.pages.iOS;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @iOSXCUITFindBy(accessibility = "test-Username")
    private ExtendedWebElement usernameInputField;

    @iOSXCUITFindBy(accessibility = "test-Password")
    private ExtendedWebElement passwordInputField;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Error message']/XCUIElementTypeStaticText")
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
