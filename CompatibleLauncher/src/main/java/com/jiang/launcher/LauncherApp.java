package com.jiang.launcher;

import android.content.Context;
import android.os.CountDownTimer;

import com.jacky.common.app.BaseApp;
import com.jiang.launcher.entity.Const;
import com.jiang.launcher.servlet.Timing_Servlet;

/**
 * Launcher Application
 *
 * @author jacky
 * @version 1.1
 * @since 2016.6.14
 */

public class LauncherApp extends BaseApp {
    private static final String TAG = "LauncherApp";

    private static Context context;

    //定时器
    TimeCount timeCount = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        if (timeCount == null) {
            timeCount = new TimeCount(Const.Timing * 1000, 1000);
            timeCount.start();
        }
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 计时器
     */
    public static class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        //倒计时完成
        @Override
        public void onFinish() {
            //间断性发出信息
            new Timing_Servlet(context).execute();
            start();
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示

        }
    }


}
