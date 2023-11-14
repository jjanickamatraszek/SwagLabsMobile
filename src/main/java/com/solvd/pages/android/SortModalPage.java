package com.solvd.pages.android;

import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.SortModalPageBase;
import com.solvd.utils.SortOption;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SortModalPageBase.class)
public class SortModalPage extends SortModalPageBase {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']//android.widget.TextView[contains(@text,'%s')]")
    private ExtendedWebElement sortOption;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/../following-sibling::android.view.ViewGroup")
    private ExtendedWebElement cancelBtn;

    public SortModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPageBase clickSortBy(SortOption sortBy) {
        sortOption.format(sortBy.get()).click();
        return initPage(getDriver(), MainPageBase.class);
    }

    @Override
    public MainPageBase clickCancel() {
        cancelBtn.click();
        return initPage(getDriver(), MainPageBase.class);
    }
}
