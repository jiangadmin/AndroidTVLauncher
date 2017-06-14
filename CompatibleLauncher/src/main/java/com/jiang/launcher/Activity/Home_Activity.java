package com.jiang.launcher.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiang.launcher.R;
import com.jiang.launcher.main.MainActivity;
import com.jiang.launcher.utils.AnimUtils;
import com.jiang.launcher.utils.LogUtil;
import com.jiang.launcher.utils.Tools;

/**
 * Created by  jiang
 * on 2017/6/12.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 主页
 * update：
 */
public class Home_Activity extends Base_Activity implements View.OnClickListener, View.OnFocusChangeListener {
    private static final String TAG = "Home_Activity";

    RelativeLayout toolbar_view;
    LinearLayout back;
    ImageView back_img;
    TextView back_txt;

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

        toolbar_view = (RelativeLayout) findViewById(R.id.toolbar_view);
        back = (LinearLayout) findViewById(R.id.back);
        back_img = (ImageView) findViewById(R.id.back_img);
        back_txt = (TextView) findViewById(R.id.back_txt);

    }

    private void initeven() {

        home1.setOnClickListener(this);
        home2.setOnClickListener(this);
        home3.setOnClickListener(this);
        home4.setOnClickListener(this);

        home1.setOnFocusChangeListener(this);
        home2.setOnFocusChangeListener(this);
        home3.setOnFocusChangeListener(this);
        home4.setOnFocusChangeListener(this);
        back.setOnFocusChangeListener(this);


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
            case KeyEvent.KEYCODE_DPAD_UP:
                LogUtil.e(TAG, "上");
                return false;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                LogUtil.e(TAG, "下");
                return false;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                LogUtil.e(TAG, "左");
                return false;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                LogUtil.e(TAG, "右");
                return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_1:
                break;
            case R.id.home_2:
                startActivity(new Intent(this, APPList_Activity.class));
                break;
            case R.id.home_3:
                break;
            case R.id.home_4:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    View lastview;

    @Override
    public void onFocusChange(View view, boolean b) {
        if (view==back){
            LogUtil.e(TAG,"返回"+b);
        }

        if (lastview != back && view == back && b) {
            AnimUtils.animupnum(toolbar_view, Tools.dp2px(this, 0));
        } else if (lastview == back && view != back) {
            AnimUtils.animupnum(toolbar_view, Tools.dp2px(this, -84));
        }

        if (b) {
            enlargeAnim(view);
        } else {
            reduceAnim(view);
        }
        lastview = view;
    }
}
