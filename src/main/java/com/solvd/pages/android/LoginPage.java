package com.solvd.pages.android;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @AndroidFindBy(accessibility = "test-Username")
    private ExtendedWebElement usernameInputField;

    @AndroidFindBy(accessibility = "test-Password")
    private ExtendedWebElement passwordInputField;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
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
