package com.solvd.dataProviders;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "passwords for empty username")
    public Object[][] passwordsForEmptyUsername() {
        return new Object[][]{{""}, {"invalid"}, {R.TESTDATA.get("password")}};
    }

    @DataProvider(name = "item titles to add single item to cart")
    public Object[][] itemsForSingleItemToCart() {
        return new Object[][]{{L10N.getText("item2.title")}, {L10N.getText("item4.title")}};
    }

    @DataProvider(name = "single items for deep link")
    public Object[][] itemsForDeepLink() {
        return new Object[][]{
                {L10N.getText("item2.title"), L10N.getText("item2.indexNumber")},
                {L10N.getText("item4.title"), L10N.getText("item4.indexNumber")}
        };
    }
}
