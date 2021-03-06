package com.jiang.launcher.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.jiang.launcher.R;
import com.jiang.launcher.adapter.AppAdapter;
import com.jiang.launcher.entity.Const;
import com.jiang.launcher.features.app.AppDataManage;
import com.jiang.launcher.model.AppBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  jiang
 * on 2017/6/12.
 * Email: www.fangmu@qq.com
 * Phone：186 6120 1018
 * Purpose:TODO APP列表
 * update：
 */
public class APPList_Activity extends AppCompatActivity {
    private static final String TAG = "APPList_Activity";

    private GridView mGridView;
    private List<AppBean> mAppList;
    private List<AppBean> showlist = new ArrayList<>();
    private AppAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applist);
        initview();
        initeven();
    }

    private void initview() {
        mGridView = (GridView) findViewById(R.id.app_grid);
    }

    //能显示的程序包名
//    String packagename = Const.芒果TV + "," + Const.优酷XL + "," + Const.魔力视频;
    String packagename = "ALL";

    private void initeven() {
        AppDataManage getAppInstance = new AppDataManage(this);
        mAppList = getAppInstance.getLaunchAppList();
        for (int i = 0; i < mAppList.size(); i++) {
            if (packagename.equals("ALL")){
                showlist.addAll(mAppList);
                continue;
            }
            if (packagename.contains(mAppList.get(i).getPackageName())) {
                showlist.add(mAppList.get(i));
            }
        }
        mAdapter = new AppAdapter(this, showlist);
        mGridView.setAdapter(mAdapter);
        mGridView.setSmoothScrollbarEnabled(true);

        if (showlist.size() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("错误");
            builder.setMessage("资源缺失，请联系服务人员!");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.show();
        } else if (showlist.size() == 1) {
            //如果就一个，那就直接启动
            startActivity(new Intent(getPackageManager().getLaunchIntentForPackage(showlist.get(0).getPackageName())));
            finish();
        }


    }
}
