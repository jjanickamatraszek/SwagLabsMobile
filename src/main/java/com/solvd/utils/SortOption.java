package com.solvd.utils;

import com.zebrunner.carina.utils.resources.L10N;

public enum SortOption {
    NAME_ASC(L10N.getText("sort.AZ")),
    NAME_DESC(L10N.getText("sort.ZA")),
    PRICE_ASC(L10N.getText("sort.LH")),
    PRICE_DESC(L10N.getText("sort.HL"));

    private String value;

    SortOption(String value) {
        this.value = value;
    }

    public String get() {
        return L10N.getText(value);
    }
}
