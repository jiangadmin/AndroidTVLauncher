package com.jiang.launcher.adapter;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.launcher.R;

import java.util.List;

public class WAndB_WifilistAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final List<ScanResult> scanResults;
    private Viewholder viewholder;
    private final Activity context;

    public WAndB_WifilistAdapter(Activity context, List<ScanResult> scanResults) {
        inflater = LayoutInflater.from(context);
        this.scanResults = scanResults;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (scanResults.size() == 0) {
            return 0;
        }
        return scanResults.size();
    }

    @Override
    public Object getItem(int arg0) {
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0, View view, ViewGroup arg2) {
        if (view == null) {
            viewholder = new Viewholder();
            view = inflater.inflate(R.layout.wandb_wifilist_item, null);
            viewholder.wifiName = (TextView) view.findViewById(R.id.wannb_wifilist_item_wifiname);
            view.setTag(viewholder);
        } else {
            viewholder = (Viewholder) view.getTag();
        }
        viewholder.wifiName.setText(scanResults.get(arg0).SSID);
        viewholder.arrowTop = (ImageView) context.findViewById(R.id.wifi_arrowtop);
        viewholder.arrowBottom = (ImageView) context.findViewById(R.id.wifi_arrowbottom);
        if (arg0 == scanResults.size() - 1) {
            viewholder.arrowBottom.setVisibility(View.INVISIBLE);
        } else {
            viewholder.arrowBottom.setVisibility(View.VISIBLE);
        }
        return view;
    }

    class Viewholder {
        public TextView wifiName;
        public ImageView arrowTop;
        public ImageView arrowBottom;
    }
}
