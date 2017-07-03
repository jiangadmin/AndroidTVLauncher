package com.jiang.launcher.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.jiang.launcher.R;
import com.jiang.launcher.activity.Base_Activity;
import com.jiang.launcher.dialog.Loading;
import com.jiang.launcher.servlet.Update_Servlet;

/**
 * Created by  jiang
 * on 2017/7/2.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 设置
 * update：
 */
public class SettingActivity extends Base_Activity implements View.OnClickListener {

    private static final String TAG = "SettingActivity";
    //网络，蓝牙，设置，文件，更新，关于
    LinearLayout setting1, setting2, setting3, setting4, setting5, setting6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysetting);
        initview();
        initeven();
    }

    private void initview() {
        setting1 = (LinearLayout) findViewById(R.id.setting_1);
        setting2 = (LinearLayout) findViewById(R.id.setting_2);
        setting3 = (LinearLayout) findViewById(R.id.setting_3);
        setting4 = (LinearLayout) findViewById(R.id.setting_4);
        setting5 = (LinearLayout) findViewById(R.id.setting_5);
        setting6 = (LinearLayout) findViewById(R.id.setting_6);
    }

    private void initeven() {
        setting1.setOnClickListener(this);
        setting2.setOnClickListener(this);
        setting3.setOnClickListener(this);
        setting4.setOnClickListener(this);
        setting5.setOnClickListener(this);
        setting6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_1:
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                break;
            case R.id.setting_2:
                startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
                break;
            case R.id.setting_3:
                break;
            case R.id.setting_4:
                break;
            case R.id.setting_5:
                Loading.show(this, "检查更新");
                new Update_Servlet().execute();
                break;
            case R.id.setting_6:
                startActivity(new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS));
                break;
        }
    }
}
