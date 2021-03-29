package com.poly.ass1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poly.ass1.R;
import com.poly.ass1.model.LoaiChi;

import java.util.List;

public class ThongKE_Loaichi_Adapter extends BaseAdapter {
    List<LoaiChi> loaiChiList;
    Context context;
    public ThongKE_Loaichi_Adapter(Context context, List<LoaiChi> loaiChiList) {
        this.context = context;
        this.loaiChiList = loaiChiList;
    }
    @Override
    public int getCount() {
        return loaiChiList.size();
    }

    @Override
    public Object getItem(int position) {
        return loaiChiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_thongke, parent, false);
        TextView textView = view.findViewById(R.id.tvthongke);
        textView.setText(loaiChiList.get(position).getLoaichi());
        return  view;
    }
}
