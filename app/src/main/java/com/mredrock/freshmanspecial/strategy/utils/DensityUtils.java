package com.mredrock.freshmanspecial.strategy.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.mredrock.freshmanspecial.APP;

/**
 * Created by Grantsome on 2017/8/4.
 */

public class DensityUtils {

    private static int screenWidth;

    private static int screenHeight;

    public static int getScreenWidth() {
        if (screenWidth == 0) {
            Context c = APP.getContext();
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }
        return screenWidth;
    }

    public static int getScreenHeight() {
        if (screenHeight == 0) {
            Context c = APP.getContext();
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }
        return screenHeight;
    }
}
