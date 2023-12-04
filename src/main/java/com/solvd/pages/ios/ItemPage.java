package com.solvd.pages.ios;

import com.solvd.pages.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name='test-Description'`]/XCUIElementTypeStaticText[1]")
    ExtendedWebElement title;

    public ItemPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }
}
