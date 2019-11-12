package com.ebrightmoon.derobot.reboot.util;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 *  on 2018/9/15.
 */

public class ColorUtil {

    private ColorUtil() {
    }

    public static String parseColorInt(@ColorInt int color) {
        return String.format("#%06X", 0xFFFFFF & color);
    }

    public static boolean isColdColor(@ColorInt int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        return hsv[2] <= 0.8f;
    }
}