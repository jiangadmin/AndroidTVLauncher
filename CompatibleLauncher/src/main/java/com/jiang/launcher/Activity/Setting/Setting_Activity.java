package com.jiang.launcher.Activity.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.jiang.launcher.Activity.Base_Activity;
import com.jiang.launcher.R;
import com.jiang.launcher.Servlet.Update_Servlet;
import com.jiang.launcher.features.app.AppAutoRun;
import com.jiang.launcher.features.app.AppUninstall;
import com.jiang.launcher.features.eliminateprocess.EliminateMainActivity;
import com.jiang.launcher.features.garbageclear.GarbageClear;
import com.jiang.launcher.features.setting.SettingCustom;
import com.jiang.launcher.features.speedtest.SpeedTestActivity;
import com.jiang.launcher.utils.Loading;

/**
 * Created by  jiang
 * on 2017/6/12.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 控制台
 * update：
 */
public class Setting_Activity extends Base_Activity implements View.OnClickListener {
    private static final String TAG = "Setting_Activity";

    //卸载应用 加速  清理  自启动
    ImageButton uninstall,gogogo;
    private ImageButton mCleanGarbage;
    private ImageButton mNetworkSetting;
    private ImageButton mOtherSetting;
    private ImageButton mNetworkSpeed;
    private ImageButton mSysUpdate;
    private ImageButton mFileManage;
    private ImageButton mAbout;
    private ImageButton mAutoRunManage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initview();
        initeven();
    }

    private void initview() {
        //获取屏幕宽度
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);

        uninstall = (ImageButton) findViewById(R.id.setting_uninstall);
        mNetworkSetting = (ImageButton) findViewById(R.id.setting_net);
        mOtherSetting = (ImageButton) findViewById(R.id.setting_more);
        mNetworkSpeed = (ImageButton) findViewById(R.id.setting_net_speed);
        mSysUpdate = (ImageButton) findViewById(R.id.setting_update);
        mFileManage = (ImageButton) findViewById(R.id.setting_file);
        mAbout = (ImageButton) findViewById(R.id.setting_about);
        mCleanGarbage = (ImageButton) findViewById(R.id.setting_clean);
        gogogo = (ImageButton) findViewById(R.id.setting_gogogo);
        mAutoRunManage = (ImageButton) findViewById(R.id.setting_autorun);

        RelativeLayout.LayoutParams ll_uninstall = (RelativeLayout.LayoutParams) uninstall.getLayoutParams();

        ll_uninstall.width = metric.widthPixels / 4;
        ll_uninstall.height = metric.heightPixels / 4;

        uninstall.setLayoutParams(ll_uninstall);
        gogogo.setLayoutParams(ll_uninstall);
        mCleanGarbage.setLayoutParams(ll_uninstall);
        mAutoRunManage.setLayoutParams(ll_uninstall);

    }

    private void initeven() {

        uninstall.setOnClickListener(this);
        gogogo.setOnClickListener(this);
        mCleanGarbage.setOnClickListener(this);
        mAbout.setOnClickListener(this);
        mOtherSetting.setOnClickListener(this);
        mNetworkSetting.setOnClickListener(this);
        mFileManage.setOnClickListener(this);
        mNetworkSpeed.setOnClickListener(this);
        mSysUpdate.setOnClickListener(this);
        mAutoRunManage.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent jumpIntent;
        switch (view.getId()) {
            case R.id.setting_clean:
                jumpIntent = new Intent(this, GarbageClear.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_accelerate:
                jumpIntent = new Intent(this, EliminateMainActivity.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_about:
                break;
            case R.id.setting_more:
                try {
                    jumpIntent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(jumpIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.setting_file:
                break;
            case R.id.setting_update:
                Loading.show(this, "检查更新");
                new Update_Servlet().execute();
                break;
            case R.id.setting_net:
                jumpIntent = new Intent(this, SettingCustom.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_uninstall:
                jumpIntent = new Intent(this, AppUninstall.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_autorun:
                jumpIntent = new Intent(this, AppAutoRun.class);
                startActivity(jumpIntent);
                break;
            case R.id.setting_net_speed:
                jumpIntent = new Intent(this, SpeedTestActivity.class);
                startActivity(jumpIntent);
                break;
            default:
                break;
        }
    }


}
