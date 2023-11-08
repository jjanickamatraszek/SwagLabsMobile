package com.solvd.base;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.utils.AuthUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public abstract class SauceDemoBaseTest implements IAbstractTest, IMobileUtils {
    protected AuthUtils authUtils;

    public SauceDemoBaseTest() {
        this.authUtils = new AuthUtils();
    }
}
