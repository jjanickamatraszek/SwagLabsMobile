package com.solvd.pages.common;

import com.solvd.utils.SortOption;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.List;

public abstract class MainPageBase extends AbstractPage implements IMobileUtils {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MainPageBase clickToggleLayoutBtn();

    public abstract SortModalPageBase clickSortBtn();

    public abstract boolean swipeToItemTitle(String itemTitle, Direction direction);

    public abstract boolean swipeToAddRemoveFromCartBtn(String itemTitle, Direction direction);

    public abstract boolean isItemTitleDisplayed(String itemTitle);

    public abstract MainPageBase clickAddToCartBtn(String itemTitle);

    public abstract MainPageBase addItemToCartByDragAndDrop(String itemTitle);

    public abstract MainPageBase clickRemoveItemFromCartBtn(String itemTitle);

    public abstract boolean isAddToCartBtnForItemVisible(String itemTitle);

    public abstract boolean isRemoveBtnForItemVisible(String itemTitle);

    public abstract boolean isSortModalVisible();

    public abstract boolean areItemsSorted(SortOption sortOption);

    public abstract List<String> getItemsTitles();

    public abstract List<BigDecimal> getItemsPrices();
}
