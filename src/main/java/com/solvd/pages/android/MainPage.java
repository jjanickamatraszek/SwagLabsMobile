package com.solvd.pages.android;

import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.SortModalPageBase;
import com.solvd.utils.SortOption;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']")
    private ExtendedWebElement toggleLayoutBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement sortBtn;

    @AndroidFindBy(accessibility = "Selector container")
    private ExtendedWebElement sortModal;

    @AndroidFindBy(accessibility = "test-PRODUCTS")
    private ExtendedWebElement itemsContainer;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private List<ExtendedWebElement> itemTitles;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<ExtendedWebElement> itemPrices;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/preceding-sibling::android.widget.ImageView")
    private ExtendedWebElement itemImageFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addItemToCartBtnFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeItemFromCartBtnFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-Drag Handle']")
    private ExtendedWebElement itemDragHandleFormatted;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/following-sibling::android.view.ViewGroup[@content-desc='test-REMOVE' or @content-desc='test-ADD TO CART']")
    private ExtendedWebElement addRemoveBtnContainerFormatted;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'drop')]")
    private ExtendedWebElement dropArea;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPageBase clickToggleLayoutBtn() {
        toggleLayoutBtn.click();
        return this;
    }

    @Override
    public SortModalPageBase clickSortBtn() {
        sortBtn.click();
        return initPage(SortModalPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return itemsContainer.isElementPresent();
    }

    @Override
    public boolean swipeToItemTitle(String itemTitle, Direction direction) {
        return swipe(itemTitleFormatted.format(itemTitle), itemsContainer, direction, 10);
    }

    @Override
    public boolean swipeToAddRemoveFromCartBtn(String itemTitle, Direction direction) {
        return swipe(addRemoveBtnContainerFormatted.format(itemTitle), itemsContainer, direction, 10);
    }

    @Override
    public boolean isItemTitleDisplayed(String itemTitle) {
        swipeToItemTitle(itemTitle, Direction.UP);
        return itemTitleFormatted.format(itemTitle).isVisible(1);
    }

    @Override
    public MainPageBase clickAddToCartBtn(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        if (addRemoveBtnContainerFormatted.format(itemTitle).isVisible()) {
            addItemToCartBtnFormatted.format(itemTitle).click();
        }
        return this;
    }

    @Override
    public MainPageBase addItemToCartByDragAndDrop(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        if (itemDragHandleFormatted.format(itemTitle).isVisible()) {
            dragAndDrop(itemDragHandleFormatted.format(itemTitle), dropArea);
        }
        return this;
    }

    @Override
    public MainPageBase clickRemoveItemFromCartBtn(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        removeItemFromCartBtnFormatted.format(itemTitle).click();
        return this;
    }

    @Override
    public boolean isAddToCartBtnForItemVisible(String itemTitle) {
        return addItemToCartBtnFormatted.format(itemTitle).isVisible();
    }

    @Override
    public boolean isRemoveBtnForItemVisible(String itemTitle) {
        return removeItemFromCartBtnFormatted.format(itemTitle).isVisible();
    }

    @Override
    public boolean isSortModalVisible() {
        return sortModal.isVisible(2);
    }

    @Override
    public boolean areItemsSorted(SortOption sortOption) {
        boolean isSorted = false;
        switch (sortOption) {
            case NAME_ASC -> {
                List<String> actual = getItemsTitles();
                List<String> expected = actual.stream().sorted().toList();
                isSorted = actual.equals(expected);
            }
            case NAME_DESC -> {
                List<String> actual = getItemsTitles();
                List<String> expected = actual.stream().sorted(Collections.reverseOrder()).toList();
                isSorted = actual.equals(expected);
            }
            case PRICE_ASC -> {
                List<BigDecimal> actual = getItemsPrices();
                List<BigDecimal> expected = actual.stream().sorted().toList();
                isSorted = actual.equals(expected);
            }
            case PRICE_DESC -> {
                List<BigDecimal> actual = getItemsPrices();
                List<BigDecimal> expected = actual.stream().sorted(Collections.reverseOrder()).toList();
                isSorted = actual.equals(expected);
            }
        }
        return isSorted;
    }

    @Override
    public List<String> getItemsTitles() {
        return itemTitles.stream().map(p -> p.getText().trim()).toList();
    }

    @Override
    public List<BigDecimal> getItemsPrices() {
        return itemPrices.stream().map(p -> new BigDecimal(p.getText().trim().replaceAll("[^0-9\\.]", ""))).toList();
    }
}
