package com.solvd.utils;

import com.solvd.pages.ios.PopupPage;
import com.solvd.pages.ios.browser.SafariStartPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class DeepLinkUtils implements IMobileUtils {

    public void closeDeepLinkPopup() {
        if (R.CONFIG.get("capabilities.platformName").equalsIgnoreCase("iOS")) {
            PopupPage popup = new PopupPage(getDriver());
            if (popup.isPageOpened(1)) {
                popup.clickOpenBtn();
            }
        }
    }

    public void openDeepLinkViaSafari(String deepLink) {
        if (R.CONFIG.get("capabilities.platformName").equalsIgnoreCase("iOS")) {
            startApp("com.apple.mobilesafari");
            SafariStartPage safari = new SafariStartPage(getDriver());
            safari.typeDeepLink(deepLink);
            safari.clickGoKey();
            closeDeepLinkPopup();
        } else {
            throw new UnsupportedOperationException("This method supports only iOS");
        }
    }

    public void openDeeplinkViaDriver(String deepLink) {
        getDriver().get(deepLink);
        closeDeepLinkPopup();
    }
}
