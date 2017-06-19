package com.jiang.launcher.features.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiang.launcher.Activity.Base_Activity;
import com.jiang.launcher.Activity.Setting.WifiHotspot_Activity;
import com.jiang.launcher.R;
import com.jiang.launcher.features.Bluetooth;
import com.jiang.launcher.features.Ethernet;
import com.jiang.launcher.features.speedtest.SpeedTestActivity;
import com.jiang.launcher.features.wifi.WifiActivity;


/**
 * @author jacky
 * @version 1.0
 * @since 2016.4.1
 */
public class SettingCustom extends Base_Activity implements View.OnClickListener {

    private TextView wifi;
    private TextView ethernet;
    private TextView bluetooth;
    private TextView detection;
    private TextView wifi_hotspot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_custom);
        initViews();
        setListener();
    }

    private void initViews() {

        wifi = (TextView) findViewById(R.id.setting_custom_wifi);
        ethernet = (TextView) findViewById(R.id.setting_custom_ethernet);
        bluetooth = (TextView) findViewById(R.id.setting_custom_bluetooth);
        detection = (TextView) findViewById(R.id.setting_custom_net_detection);
        wifi_hotspot = (TextView) findViewById(R.id.setting_custom_wifi_hotspot);

    }

    private void setListener() {

        wifi.setOnClickListener(this);
        ethernet.setOnClickListener(this);
        bluetooth.setOnClickListener(this);
        detection.setOnClickListener(this);
        wifi_hotspot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.setting_custom_wifi:
                startActivity(new Intent(this, WifiActivity.class));
                break;
            case R.id.setting_custom_ethernet:
                startActivity(new Intent(this, Ethernet.class));
                break;
            case R.id.setting_custom_bluetooth:
                startActivity(new Intent(this, Bluetooth.class));
                break;
            case R.id.setting_custom_net_detection:
                startActivity(new Intent(this, SpeedTestActivity.class));
                break;
            case R.id.setting_custom_wifi_hotspot:
                startActivity(new Intent(this, WifiHotspot_Activity.class));
                break;
            default:
                break;
        }
    }
}