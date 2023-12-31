package com.solvd.mainPage;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.dataProviders.DataProviders;
import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.MainPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveItemsFromCartTest extends SauceDemoBaseTest {

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-17"})
    public void addSingleItemToCartTest(String expectedItemTitle) {
        int expectedAmountOfItems = 1;

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present on the screen".formatted(expectedItemTitle));
        mainPage.clickAddToCartBtn(expectedItemTitle);
        Assert.assertTrue(mainPage.isRemoveBtnForItemVisible(expectedItemTitle),
                "Remove btn for item '%s' isn't visible after adding item to cart".formatted(expectedItemTitle));

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present in cart".formatted(expectedItemTitle));
    }

    @Test
    @TestCaseKey({"JOANNA-18"})
    public void addFiveItemsToCartTest() {
        int expectedAmountOfItems = 5;
        List<String> itemTitles = List.of(L10N.getText("item1.title"),
                L10N.getText("item2.title"), L10N.getText("item3.title"),
                L10N.getText("item4.title"), L10N.getText("item5.title"));

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        for (String expectedItemTitle : itemTitles) {
            mainPage.clickAddToCartBtn(expectedItemTitle);
        }

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = topBar.clickCartBtn();
        for (String expectedItemTitle : itemTitles) {
            Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                    "Item '%s' isn't present in the cart".formatted(expectedItemTitle));
        }
    }

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-19"})
    public void removeSingleItemFromCartTest(String expectedItemTitle) {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickAddToCartBtn(L10N.getText("item1.title"));
        mainPage.clickAddToCartBtn(expectedItemTitle);
        mainPage.clickRemoveItemFromCartBtn(expectedItemTitle);
        Assert.assertTrue(mainPage.isAddToCartBtnForItemVisible(expectedItemTitle),
                "Btn 'Add to cart' didn't appear after removing item from cart");

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), 1,
                "Amount of items on cart icon didn't decrease after removing item from cart");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertFalse(cartPage.swipeToItemTitle(expectedItemTitle, Direction.UP, 4),
                "Item '%s' is still present in cart".formatted(expectedItemTitle));
    }

    @Test
    @TestCaseKey({"JOANNA-20"})
    public void removeAllItemsFromCartTest() {
        List<String> itemTitles = List.of(L10N.getText("item1.title"),
                L10N.getText("item2.title"), L10N.getText("item3.title"),
                L10N.getText("item4.title"), L10N.getText("item5.title"));

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        for (String expectedItemTitle : itemTitles) {
            mainPage.clickAddToCartBtn(expectedItemTitle);
        }
        mainPage.swipeToItemTitle(L10N.getText("item1.title"), Direction.DOWN);
        for (String expectedItemTitle : itemTitles) {
            mainPage.clickRemoveItemFromCartBtn(expectedItemTitle);
        }

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertFalse(topBar.isItemsAmountVisible(),
                "Amount of items on cart icon is still visible after removing all items from cart");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertTrue(cartPage.isCartEmpty(),
                "Cart isn't empty after removing all added items");
    }

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-21"})
    public void addSingleItemToCartByDragAndDropTest(String expectedItemTitle) {
        int expectedAmountOfItems = 1;

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present on the screen".formatted(expectedItemTitle));
        mainPage.addItemToCartByDragAndDrop(expectedItemTitle);
        Assert.assertTrue(mainPage.isRemoveBtnForItemVisible(expectedItemTitle),
                "Remove btn for item '%s' isn't visible after adding item to cart".formatted(expectedItemTitle));

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present in cart".formatted(expectedItemTitle));
    }

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-22"})
    public void addSingleItemToCartInListLayoutTest(String expectedItemTitle) {
        int expectedAmountOfItems = 1;

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn();
        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);

        Assert.assertTrue(mainPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present on the screen".formatted(expectedItemTitle));
        mainPage.clickAddToCartBtn(expectedItemTitle);
        Assert.assertTrue(mainPage.isRemoveBtnForItemVisible(expectedItemTitle),
                "Remove btn for item '%s' isn't visible after adding item to cart".formatted(expectedItemTitle));
        Assert.assertEquals(topBar.getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present in cart".formatted(expectedItemTitle));
    }

    @Test
    @TestCaseKey({"JOANNA-23"})
    public void addFiveItemsToCartInListLayoutTest() {
        int expectedAmountOfItems = 5;
        List<String> itemTitles = List.of(L10N.getText("item1.title"),
                L10N.getText("item2.title"), L10N.getText("item3.title"),
                L10N.getText("item4.title"), L10N.getText("item5.title"));

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn();
        for (String expectedItemTitle : itemTitles) {
            mainPage.clickAddToCartBtn(expectedItemTitle);
        }

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");
        CartPageBase cartPage = topBar.clickCartBtn();
        for (String expectedItemTitle : itemTitles) {
            Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                    "Item '%s' isn't present in the cart".formatted(expectedItemTitle));
        }
    }

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-24"})
    public void removeSingleItemFromCartInListLayoutTest(String expectedItemTitle) {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn();
        mainPage.clickAddToCartBtn(L10N.getText("item1.title"));
        mainPage.clickAddToCartBtn(expectedItemTitle);
        mainPage.clickRemoveItemFromCartBtn(expectedItemTitle);
        Assert.assertTrue(mainPage.isAddToCartBtnForItemVisible(expectedItemTitle),
                "Btn 'Add to cart' didn't appear after removing item from cart");

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), 1,
                "Amount of items on cart icon didn't decrease after removing item from cart");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertFalse(cartPage.swipeToItemTitle(expectedItemTitle, Direction.UP, 4),
                "Item '%s' is still present in cart".formatted(expectedItemTitle));
    }

    @Test
    @TestCaseKey({"JOANNA-25"})
    public void removeAllItemsFromCartInListLayoutTest() {
        List<String> itemTitles = List.of(L10N.getText("item1.title"),
                L10N.getText("item2.title"), L10N.getText("item3.title"),
                L10N.getText("item4.title"), L10N.getText("item5.title"));

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn();
        for (String expectedItemTitle : itemTitles) {
            mainPage.clickAddToCartBtn(expectedItemTitle);
        }
        mainPage.swipeToItemTitle(L10N.getText("item1.title"), Direction.DOWN);
        for (String expectedItemTitle : itemTitles) {
            mainPage.clickRemoveItemFromCartBtn(expectedItemTitle);
        }

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertFalse(topBar.isItemsAmountVisible(),
                "Amount of items on cart icon is still visible after removing all items from cart");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertTrue(cartPage.isCartEmpty(),
                "Cart isn't empty after removing all added items");
    }

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-27"})
    public void addSingleItemToCartByDragAndDropInListLayoutTest(String expectedItemTitle) {
        int expectedAmountOfItems = 1;

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn();
        Assert.assertTrue(mainPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present on the screen".formatted(expectedItemTitle));
        mainPage.addItemToCartByDragAndDrop(expectedItemTitle);
        Assert.assertTrue(mainPage.isRemoveBtnForItemVisible(expectedItemTitle),
                "Remove btn for item '%s' isn't visible after adding item to cart".formatted(expectedItemTitle));

        TopAppBarPageBase topBar = initPage(TopAppBarPageBase.class);
        Assert.assertEquals(topBar.getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = topBar.clickCartBtn();
        Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present in cart".formatted(expectedItemTitle));
    }
}
