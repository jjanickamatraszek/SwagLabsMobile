package com.solvd.pages.common;

import com.solvd.utils.SortOption;
import org.openqa.selenium.WebDriver;

public abstract class SortModalPageBase extends BaseSauceDemoPageBase {

    protected SortModalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSortBy(SortOption sortOption);

    public abstract void clickCancel();
}
