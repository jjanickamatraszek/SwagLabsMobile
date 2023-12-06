package com.solvd.pages.android;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='{L10N:loginPage.username.name}']")
    private ExtendedWebElement usernameInputField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='{L10N:loginPage.password.name}']")
    private ExtendedWebElement passwordInputField;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'test-Error')]/android.widget.TextView")
    private ExtendedWebElement errorMessageText;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(passwordInputField);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void typeName(String name) {
        waitUntil(ExpectedConditions.visibilityOf(usernameInputField.getElement()), 3);
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
