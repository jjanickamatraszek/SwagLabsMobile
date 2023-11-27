package com.solvd.pages.ios;

import com.solvd.pages.common.SortModalPageBase;
import com.solvd.utils.SortOption;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortModalPageBase.class)
public class SortModalPage extends SortModalPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name = '%s']")
    private ExtendedWebElement sortOption;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='Cancel']")
    private ExtendedWebElement cancelBtn;

    public SortModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSortBy(SortOption sortBy) {
        sortOption.format(sortBy.get()).click();
    }

    @Override
    public void clickCancel() {
        cancelBtn.click();
    }
}
