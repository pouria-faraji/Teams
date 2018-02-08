package com.forza.home.assignments.teams.application;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class Global {
    public static String TEAMS_URL = "https://s3-eu-west-1.amazonaws.com/forza-assignment/android/teams.json";
    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = App.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = App.getAppContext().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public  static int getAppHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) App.getAppContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
//        App.getAppContext().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int statusBarHeight = getStatusBarHeight();
        int app_height = metrics.heightPixels - statusBarHeight;

        return app_height;
    }

    public  static int getAppWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) App.getAppContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        int app_width = metrics.widthPixels;
        return app_width;
    }
    public static int dp_to_px(int dp){
        Resources r = App.getAppContext().getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return (int) px;
    }

    public static int px_to_dp(int px){
        Resources r = App.getAppContext().getResources();
        float dp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, r.getDisplayMetrics());
        return (int) dp;
    }
}
