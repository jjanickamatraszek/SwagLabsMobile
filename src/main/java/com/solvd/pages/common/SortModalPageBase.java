package com.solvd.pages.common;

import com.solvd.utils.SortOption;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SortModalPageBase extends AbstractPage {

    protected SortModalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MainPageBase clickSortBy(SortOption sortOption);

    public abstract MainPageBase clickCancel();
}
