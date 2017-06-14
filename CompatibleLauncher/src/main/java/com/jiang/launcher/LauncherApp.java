package com.jiang.launcher;

import android.content.Context;

import com.jacky.common.app.BaseApp;

/**
 * Launcher Application
 *
 * @author jacky
 * @version 1.1
 * @since 2016.6.14
 */

public class LauncherApp extends BaseApp {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
