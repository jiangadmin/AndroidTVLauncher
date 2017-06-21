package com.jiang.launcher.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jiang.launcher.R;
import com.jiang.launcher.utils.LogUtil;


/**
 * Created by  jiang
 * on 2017/6/21.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO 输入密码
 * update：
 */
public class Password_Dialog extends Dialog {
    private static final String TAG = "Password_Dialog";
    private Activity context;
    private View customView;
    RelativeLayout view;
    ImageView pwd1, pwd2, pwd3, pwd4, pwd5, pwd6;
    String pwd = "";

    public Password_Dialog(Activity context) {
        super(context);
        this.context = context;
    }

    public Password_Dialog(Activity context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        customView = inflater.inflate(R.layout.dialog_pwd, null);

        view = (RelativeLayout) customView.findViewById(R.id.pwd_dialog_view);

        pwd1 = (ImageView) customView.findViewById(R.id.pwd_1);
        pwd2 = (ImageView) customView.findViewById(R.id.pwd_2);
        pwd3 = (ImageView) customView.findViewById(R.id.pwd_3);
        pwd4 = (ImageView) customView.findViewById(R.id.pwd_4);
        pwd5 = (ImageView) customView.findViewById(R.id.pwd_5);
        pwd6 = (ImageView) customView.findViewById(R.id.pwd_6);


        LogUtil.e(TAG,"宽度:"+view.getWidth());
        LogUtil.e(TAG,"高度:"+view.getHeight());
        Display display = context.getWindowManager().getDefaultDisplay();
        LogUtil.e(TAG,"宽度:"+display.getWidth());
        LogUtil.e(TAG,"高度:"+display.getHeight());

    }

    protected Password_Dialog(Activity context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(customView);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                setPwd(R.drawable.ic_up, 8);
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                setPwd(R.drawable.ic_down, 2);
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                setPwd(R.drawable.ic_left, 4);
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                setPwd(R.drawable.ic_right, 6);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 设置显示
     *
     * @param resId 显示图片
     * @param npwd  密码
     */
    public void setPwd(int resId, int npwd) {
        pwd = pwd + String.valueOf(npwd);
        switch (pwd.length()) {
            case 1:
                pwd1.setImageResource(resId);
                break;
            case 2:
                pwd2.setImageResource(resId);
                break;
            case 3:
                pwd3.setImageResource(resId);
                break;
            case 4:
                pwd4.setImageResource(resId);
                break;
            case 5:
                pwd5.setImageResource(resId);
                break;
            case 6:
                pwd6.setImageResource(resId);
                dismiss();
                break;
        }

    }


}
