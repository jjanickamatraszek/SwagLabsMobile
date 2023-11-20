package com.solvd.mainPage;

import com.solvd.base.SauceDemoBaseTest;
import com.solvd.pages.common.MainPageBase;
import com.solvd.utils.SortOption;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

public class SortItemsTest extends SauceDemoBaseTest {

    @Test
    @TestCaseKey({"JOANNA-28"})
    public void sortItemsByNameAscTest() {
        SortOption sortOption = SortOption.NAME_ASC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by name ASC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsTitles(), mainPage.getItemsTitles().stream().sorted().toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-29"})
    public void sortItemsByNameDescTest() {
        SortOption sortOption = SortOption.NAME_DESC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by name DESC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsTitles(), mainPage.getItemsTitles().stream().sorted(Collections.reverseOrder()).toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-30"})
    public void sortItemsByPriceAscTest() {
        SortOption sortOption = SortOption.PRICE_ASC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by price ASC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsPrices(), mainPage.getItemsPrices().stream().sorted().toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-31"})
    public void sortItemsByPriceDescTest() {
        SortOption sortOption = SortOption.PRICE_DESC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by price DESC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsPrices(), mainPage.getItemsPrices().stream().sorted().toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-36"})
    public void cancelSortTest() {
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickSortBtn()
                .clickCancel();
        Assert.assertFalse(mainPage.isSortModalVisible(), "Sort modal is still visible after clicking 'Cancel'");
    }

    @Test
    @TestCaseKey({"JOANNA-32"})
    public void sortItemsByNameAscInListLayoutTest() {
        SortOption sortOption = SortOption.NAME_ASC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn()
                .clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by name ASC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsTitles(), mainPage.getItemsTitles().stream().sorted().toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-33"})
    public void sortItemsByNameDescInListLayoutTest() {
        SortOption sortOption = SortOption.NAME_DESC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn()
                .clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by name DESC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsTitles(), mainPage.getItemsTitles().stream().sorted(Collections.reverseOrder()).toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-34"})
    public void sortItemsByPriceAscInListLayoutTest() {
        SortOption sortOption = SortOption.PRICE_ASC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn()
                .clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by price ASC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsPrices(), mainPage.getItemsPrices().stream().sorted().toList()));
    }

    @Test
    @TestCaseKey({"JOANNA-35"})
    public void sortItemsByPriceDescInListLayoutTest() {
        SortOption sortOption = SortOption.PRICE_DESC;

        R.CONFIG.put("capabilities.allowInvisibleElements", "true");
        MainPageBase mainPage = authUtils.loginWithDefaultUser();
        mainPage.clickToggleLayoutBtn()
                .clickSortBtn()
                .clickSortBy(sortOption);
        Assert.assertTrue(mainPage.areItemsSorted(sortOption),
                "Items aren't sorted by price DESC. Actual titles: %s\n Expected titles: %s"
                        .formatted(mainPage.getItemsPrices(), mainPage.getItemsPrices().stream().sorted().toList()));
    }
}
