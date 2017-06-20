package com.jiang.launcher.Activity.Setting;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Switch;

import com.jiang.launcher.Activity.Base_Activity;
import com.jiang.launcher.R;
import com.jiang.launcher.utils.LogUtil;

import java.lang.reflect.Method;

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

    EditText name, pwd;

    Switch swicth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_hotspot);
        initview();
        initeven();
    }

    private void initview() {
        name = (EditText) findViewById(R.id.wifi_hotspot_name);
        pwd = (EditText) findViewById(R.id.wifi_hotspot_pwd);
        swicth = (Switch) findViewById(R.id.wifi_hotspot_switch);

        //获取wifi管理服务
        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

    }

    private void initeven() {
        name.setText(getValidApSsid());
        pwd.setText(getValidPassword());

        LogUtil.e(TAG,"WIFI热点状态:"+getWifiAPState());

        switch (getWifiAPState()){
            case 11:
                swicth.setChecked(false);
                break;

        }
    }


    /**
     * 获取热点SSID
     * @return
     */
    public String getValidApSsid() {
        try {
            Method method = wifiManager.getClass().getMethod("getWifiApConfiguration");
            WifiConfiguration configuration = (WifiConfiguration) method.invoke(wifiManager);
            return configuration.SSID;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            return null;
        }
    }

    /**
     * 获取热点密码
     * @return
     */
    public String getValidPassword() {
        try {
            Method method = wifiManager.getClass().getMethod("getWifiApConfiguration");
            WifiConfiguration configuration = (WifiConfiguration) method.invoke(wifiManager);
            return configuration.preSharedKey;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            return null;
        }
    }


    /**
     * 获取热点状态
     * @return
     */
    public int getWifiAPState() {
        int state = -1;
        try {
            Method method2 = wifiManager.getClass().getMethod("getWifiApState");
            state = (Integer) method2.invoke(wifiManager);
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
        }
        return state;
    }
}
