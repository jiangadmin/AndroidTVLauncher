package com.jiang.launcher.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiang.launcher.R;
import com.jiang.launcher.utils.LogUtil;

/**
 * Created by  jiang
 * on 2017/6/14.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 公共Activity
 * update：
 */
public class Base_Activity extends AppCompatActivity  {
    private static final String TAG = "Base_Activity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private View mCurrentView;

    public View.OnFocusChangeListener mFocusChangeListener = new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                mCurrentView = v;
                enlargeAnim(v);
            } else {
                reduceAnim(v);
            }
        }
    };

    public View getCurrentView() {
        return mCurrentView;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public void requestInitFocus(){

    }

    public View.OnFocusChangeListener getFocusChangeListener() {
        return mFocusChangeListener;
    }

    public void enlargeAnim(View v) {
        Animation a = AnimationUtils.loadAnimation(v.getContext(), com.jacky.uikit.R.anim.uikit_enlarge);
        a.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
        a.setFillAfter(true);
        v.clearAnimation();
        v.setAnimation(a);
//        v.bringToFront();
        a.start();
    }

    public void reduceAnim(View v) {
        Animation a = AnimationUtils.loadAnimation(v.getContext(), com.jacky.uikit.R.anim.uikit_reduce);
        a.setFillAfter(true);
        v.clearAnimation();
        v.startAnimation(a);
        a.start();
    }

}
