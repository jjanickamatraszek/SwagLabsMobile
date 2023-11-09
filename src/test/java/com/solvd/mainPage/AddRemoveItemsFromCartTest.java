package com.solvd.mainPage;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.dataProviders.DataProviders;
import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.MainPageBase;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddRemoveItemsFromCartTest extends SauceDemoBaseTest {

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    public void addSingleItemToCartTest(String expectedItemTitle) {
        int expectedAmountOfItems = 1;

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        Assert.assertTrue(mainPage.isItemDisplayed(expectedItemTitle),
                "Item '%s' isn't present on the screen".formatted(expectedItemTitle));
        mainPage.addItemToCart(expectedItemTitle);

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(mainPage.isRemoveBtnForItemVisible(expectedItemTitle),
                "Remove btn for item '%s' isn't visible after adding item to cart".formatted(expectedItemTitle));
        soft.assertEquals(mainPage.getTopAppBar().getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = mainPage.getTopAppBar().goToCart();
        soft.assertTrue(cartPage.isItemDisplayed(expectedItemTitle),
                "Item '%s' isn't present in cart".formatted(expectedItemTitle));
        soft.assertAll();
    }

    @Test
    public void addSingleItemToCartWithImageLocatorTest() {

    }

    @Test
    public void addFiveItemsToCartTest() {
        int expectedAmountOfItems = 5;
        List<String> itemTitles = List.of(L10N.getText("item1.title"),
                L10N.getText("item2.title"), L10N.getText("item3.title"),
                L10N.getText("item4.title"), L10N.getText("item5.title"));

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        for (String expectedItemTitle : itemTitles) {
            mainPage.addItemToCart(expectedItemTitle);
        }

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mainPage.getTopAppBar().getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");

        CartPageBase cartPage = mainPage.getTopAppBar().goToCart();
        for (String expectedItemTitle : itemTitles) {
            soft.assertTrue(cartPage.isItemDisplayed(expectedItemTitle),
                    "Item '%s' isn't present in the cart".formatted(expectedItemTitle));
        }
        soft.assertAll();
    }

    @Test(dataProvider = "item titles to add single item to cart", dataProviderClass = DataProviders.class)
    public void removeSingleItemFromCartTest(String expectedItemTitle) {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.addItemToCart(L10N.getText("item1.title"));
        mainPage.addItemToCart(expectedItemTitle);
        mainPage.removeItemFromCart(expectedItemTitle);

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(mainPage.isAddToCartBtnForItemVisible(expectedItemTitle),
                "Btn 'Add to cart' didn't appear after removing item from cart");
        soft.assertEquals(mainPage.getTopAppBar().getItemsAmountInCart(), 1,
                "Amount of items on cart icon didn't decrease after removing item from cart");

        CartPageBase cartPage = mainPage.getTopAppBar().goToCart();
        soft.assertFalse(cartPage.swipeToItem(expectedItemTitle, Direction.UP, 4),
                "Item '%s' is still present in cart".formatted(expectedItemTitle));
        soft.assertAll();
    }

    @Test
    public void removeAllItemsFromCartTest() {
        List<String> itemTitles = List.of(L10N.getText("item1.title"),
                L10N.getText("item2.title"), L10N.getText("item3.title"),
                L10N.getText("item4.title"), L10N.getText("item5.title"));

        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        for (String expectedItemTitle : itemTitles) {
            mainPage.addItemToCart(expectedItemTitle);
        }
        mainPage.swipeToItem(L10N.getText("item1.title"), Direction.DOWN);
        for (String expectedItemTitle : itemTitles) {
            mainPage.removeItemFromCart(expectedItemTitle);
        }

        SoftAssert soft = new SoftAssert();
        soft.assertFalse(mainPage.getTopAppBar().isItemsAmountVisible(),
                "Amount of items on cart icon is still visible after removing all items from cart");

        CartPageBase cartPage = mainPage.getTopAppBar().goToCart();
        soft.assertTrue(cartPage.isCartEmpty(),
                "Cart isn't empty after removing all added items");
        soft.assertAll();
    }

    @Test
    public void addSingleItemToCartByDragAndDropTest() {

    }
}
