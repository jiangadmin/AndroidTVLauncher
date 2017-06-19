package com.jiang.launcher.Activity.Setting;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jiang.launcher.Activity.Base_Activity;
import com.jiang.launcher.R;

/**
 * Created by  jiang
 * on 2017/6/19.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO WIFI 热点
 * update：
 */
public class WifiHotspot_Activity extends Base_Activity {
    private static final String TAG = "WifiHotspot_Activity";
    private WifiManager wifiManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_hotspot);
        initview();
        initeven();
    }

    private void initview() {
        //获取wifi管理服务
        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

    }

    private void initeven() {

    }
}
