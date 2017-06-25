package com.jiang.launcher.servlet;

import android.os.AsyncTask;
import android.os.CountDownTimer;

import com.jiang.launcher.entity.Const;
import com.jiang.launcher.utils.HttpUtil;
import com.jiang.launcher.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  jiang
 * on 2017/6/19.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 定时发送
 * update：
 */
public class Timing_Servlet extends AsyncTask<String, Integer, String> {
    private static final String TAG = "Timing_Servlet";

    @Override
    protected String doInBackground(String... strings) {
        Const.timeCount.start();
        Map map = new HashMap();
        map.put("text", "定时发送请求");
        String res = HttpUtil.doPost(Const.URL + "Timing", map);
        LogUtil.e(TAG, "定时发送");

        return null;
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
            new Timing_Servlet().execute();

        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示

        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
