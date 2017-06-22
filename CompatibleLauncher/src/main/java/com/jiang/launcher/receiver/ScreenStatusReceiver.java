package com.jiang.launcher.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jiang.launcher.utils.LogUtil;

/**
 * Created by  jiang
 * on 2017/6/19.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 亮屏息屏广播接收
 * update：
 */
public class ScreenStatusReceiver extends BroadcastReceiver {
    private static final String TAG = "ScreenStatusReceiver";
    String SCREEN_ON = "android.intent.action.SCREEN_ON";
    String SCREEN_OFF = "android.intent.action.SCREEN_OFF";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (SCREEN_ON.equals(intent.getAction())) {
            LogUtil.e(TAG, "亮屏");

        } else if (SCREEN_OFF.equals(intent.getAction())) {
            LogUtil.e(TAG, "息屏");
        }
    }
}