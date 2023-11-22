package com.solvd.utils;

public enum DeepLink {
    ITEM_PAGE("swaglabs://swag-item/"),
    PERSONAL_INFO("swaglabs://personal-info/1"),
    CART("swaglabs://cart/");

    private String url;

    DeepLink(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
