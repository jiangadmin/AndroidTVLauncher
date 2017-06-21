package com.jiang.launcher.servlet;

import android.os.AsyncTask;

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
public class Timing_Servlet extends AsyncTask<String,Integer,String> {
    private static final String TAG = "Timing_Servlet";
    @Override
    protected String doInBackground(String... strings) {
        Map map = new HashMap();
        map.put("","");

        String res = HttpUtil.doPost(Const.URL,map);
        LogUtil.e(TAG,"定时发送");

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
