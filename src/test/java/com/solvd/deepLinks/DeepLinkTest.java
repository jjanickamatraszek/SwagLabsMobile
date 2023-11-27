package com.solvd.deepLinks;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.dataProviders.DataProviders;
import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.ItemPageBase;
import com.solvd.pages.common.TopAppBarPageBase;
import com.solvd.utils.DeepLink;
import com.solvd.utils.PageUtils;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class DeepLinkTest extends SauceDemoBaseTest {
    private final String appPackageName = R.CONFIG.get("capabilities.appPackage");

    @Test(dataProvider = "single items for deep link", dataProviderClass = DataProviders.class)
    @TestCaseKey({"JOANNA-41"})
    public void openItemPageByDeepLinkTest(String title, String itemIndexNumber) {
        String expectedItemTitle = L10N.getText(title);
        String deepLink = DeepLink.CART.getUrl() + itemIndexNumber;

        terminateApp(appPackageName);
        Assert.assertFalse(isAppRunning(appPackageName),
                "Swag Labs app is still running although it should be terminated.");

        (new PageUtils()).openDeepLink(deepLink);

        ItemPageBase itemPage = initPage(ItemPageBase.class);
        Assert.assertTrue(itemPage.isPageOpened(),
                "Item page hasn't been opened");
        Assert.assertEquals(itemPage.getTitle(), expectedItemTitle,
                "Title displayed on item page is different than expected");
    }

    @Test
    @TestCaseKey({"JOANNA-42"})
    public void addSingleItemToCartByDeepLinkTest() {
        String expectedItemTitle = L10N.getText("item2.title");
        String itemIndexNumber = L10N.getText("item2.indexNumber");
        int expectedAmountOfItems = 1;

        terminateApp(appPackageName);
        getDriver().get(DeepLink.CART.getUrl() + itemIndexNumber);
        (new PageUtils()).closeDeepLinkPopup();

        CartPageBase cartPage = initPage(CartPageBase.class);
        Assert.assertTrue(cartPage.isPageOpened(),
                "Cart page hasn't been opened");
        Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                "Item '%s' isn't present in cart".formatted(expectedItemTitle));
        Assert.assertEquals(initPage(TopAppBarPageBase.class).getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");
    }

    @Test
    @TestCaseKey({"JOANNA-43"})
    public void addThreeItemsToCartByDeepLinkTest() {
        Map<String, String> items = Map.of(
                L10N.getText("item1.indexNumber"), L10N.getText("item1.title"),
                L10N.getText("item2.indexNumber"), L10N.getText("item2.title"),
                L10N.getText("item3.indexNumber"), L10N.getText("item3.title"));
        int expectedAmountOfItems = 3;

        terminateApp(appPackageName);
        getDriver().get(DeepLink.CART.getUrl() + String.join(",", items.keySet()));
        (new PageUtils()).closeDeepLinkPopup();

        CartPageBase cartPage = initPage(CartPageBase.class);
        Assert.assertTrue(cartPage.isPageOpened(),
                "Cart page hasn't been opened");
        for (String expectedItemTitle : items.values()) {
            Assert.assertTrue(cartPage.isItemTitleDisplayed(expectedItemTitle),
                    "Item '%s' isn't present in the cart".formatted(expectedItemTitle));
        }
        Assert.assertEquals(initPage(TopAppBarPageBase.class).getItemsAmountInCart(), expectedAmountOfItems,
                "Amount of items displayed on cart icon is different than expected");
    }
}
