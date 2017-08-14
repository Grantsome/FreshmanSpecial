package com.mredrock.freshmanspecial;

import android.app.Application;
import android.content.Context;

/**
 * Created by Grantsome on 2017/8/3.
 */

public class APP extends Application {

    private static Context context;

    public static final String TAG = "APP";

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }


    public static Context getContext() {
        return context;
    }
}
