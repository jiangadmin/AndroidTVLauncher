package com.jiang.launcher.Servlet;

import android.os.AsyncTask;

import com.jiang.launcher.Entity.Const;
import com.jiang.launcher.utils.HttpUtil;
import com.jiang.launcher.utils.Loading;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  jiang
 * on 2017/6/19.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 检查更新请求
 * update：
 */
public class Update_Servlet extends AsyncTask<String,Integer,String> {
    private static final String TAG = "Update_Servlet";
    @Override
    protected String doInBackground(String... strings) {
        Map map =new HashMap();

        String res = HttpUtil.doPost(Const.URL,map);
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Loading.dismiss();
    }
}
