package com.jiang.launcher.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.jiang.launcher.R;
import com.jiang.launcher.adapter.AppAdapter;
import com.jiang.launcher.features.app.AppDataManage;
import com.jiang.launcher.model.AppBean;
import com.jiang.launcher.utils.LogUtil;

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
    private List<AppBean> showlist =new ArrayList<>();
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
    String packagename = "com.jiang.launcher";

    private void initeven() {
        AppDataManage getAppInstance = new AppDataManage(this);
        mAppList = getAppInstance.getLaunchAppList();
        for (int i = 0; i <mAppList.size() ; i++) {
            if (packagename.indexOf(mAppList.get(i).getPackageName())!=-1){
                showlist.add(mAppList.get(i));
            }
        }
        mAdapter = new AppAdapter(this, mAppList);
        mGridView.setAdapter(mAdapter);
        mGridView.setSmoothScrollbarEnabled(true);

    }
}
