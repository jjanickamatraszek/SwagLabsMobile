package com.solvd.utils;

import java.awt.*;

public enum ImageColor {
    GREY(new Color(71, 76, 85));

    ImageColor(Color color) {
        this.RGB = color;
    }

    private final Color RGB;

    public Color getRGB() {
        return RGB;
    }
}
