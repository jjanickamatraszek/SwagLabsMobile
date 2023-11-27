package com.solvd.pages.ios;

import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.SortModalPageBase;
import com.solvd.utils.SortOption;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @iOSXCUITFindBy(accessibility = "test-Toggle")
    private ExtendedWebElement toggleLayoutBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Modal Selector Button']")
    private ExtendedWebElement sortBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='Selector container']")
    private ExtendedWebElement sortModal;

    @iOSXCUITFindBy(accessibility = "test-PRODUCTS")
    private ExtendedWebElement itemsContainer;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title']")
    private List<ExtendedWebElement> itemTitles;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Price']")
    private List<ExtendedWebElement> itemPrices;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title' and @text='%s']/preceding-sibling::XCUIElementTypeOther[@name]")
    private ExtendedWebElement itemImageFormatted;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']")
    private ExtendedWebElement itemTitleFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-ADD TO CART']")
    private ExtendedWebElement addItemToCartBtnFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-REMOVE']")
    private ExtendedWebElement removeItemFromCartBtnFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-Drag Handle']")
    private ExtendedWebElement itemDragHandleFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']]//XCUIElementTypeOther[@name='test-REMOVE' or @name='test-ADD TO CART']")
    private ExtendedWebElement addRemoveBtnContainerFormatted;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart drop zone']")
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
        return swipeToItemTitle(itemTitle, Direction.UP);
    }

    @Override
    public MainPageBase clickAddToCartBtn(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        int width = addItemToCartBtnFormatted.format(itemTitle).getSize().getWidth();
        int height = addItemToCartBtnFormatted.format(itemTitle).getSize().getHeight();
        int x = addItemToCartBtnFormatted.format(itemTitle).getLocation().getX();
        int y = addItemToCartBtnFormatted.format(itemTitle).getLocation().getY();
        int movedX = (int) Math.round(x + width * 0.8);
        int movedY = (int) Math.round(y + height * 0.2);
        tap(movedX, movedY);
        return this;
    }

    @Override
    public MainPageBase addItemToCartByDragAndDrop(String itemTitle) {
        swipeToAddRemoveFromCartBtn(itemTitle, Direction.UP);
        dragAndDrop(itemDragHandleFormatted.format(itemTitle), dropArea);
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
