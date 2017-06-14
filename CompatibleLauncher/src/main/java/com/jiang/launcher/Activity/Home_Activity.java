package com.jiang.launcher.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.jiang.launcher.R;
import com.jiang.launcher.main.MainActivity;

/**
 * Created by  jiang
 * on 2017/6/12.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 主页
 * update：
 */
public class Home_Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Home_Activity";
    RelativeLayout home1, home2, home3, home4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_home);
        initview();
        initeven();
    }

    private void initview() {

        home1 = (RelativeLayout) findViewById(R.id.home_1);
        home2 = (RelativeLayout) findViewById(R.id.home_2);
        home3 = (RelativeLayout) findViewById(R.id.home_3);
        home4 = (RelativeLayout) findViewById(R.id.home_4);

    }

    private void initeven() {

        home1.setOnClickListener(this);
        home2.setOnClickListener(this);
        home3.setOnClickListener(this);
        home4.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                //长按
                if (event.getRepeatCount() == 3)

                    break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_1:
                break;
            case R.id.home_2:
                startActivity(new Intent(this,APPList_Activity.class));
                break;
            case R.id.home_3:
                break;
            case R.id.home_4:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
