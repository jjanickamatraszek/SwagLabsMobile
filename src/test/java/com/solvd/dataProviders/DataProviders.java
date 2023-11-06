package com.solvd.dataProviders;

import com.zebrunner.carina.utils.R;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "passwords for empty username")
    public Object[][] passwordsForEmptyUsername() {
        return new Object[][]{{""}, {"invalid"}, {R.TESTDATA.get("password")}};
    }
}
