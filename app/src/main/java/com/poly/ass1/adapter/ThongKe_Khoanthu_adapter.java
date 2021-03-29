package com.poly.ass1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poly.ass1.R;
import com.poly.ass1.model.KhoanChi;
import com.poly.ass1.model.Khoanthu;
import com.poly.ass1.model.LoaiChi;

import java.util.List;

public class ThongKe_Khoanthu_adapter extends BaseAdapter {
    List<Khoanthu> khoanthuList;
    Context context;
    public ThongKe_Khoanthu_adapter(Context context, List<Khoanthu> khoanthuList) {
        this.context = context;
        this.khoanthuList = khoanthuList;
    }
    @Override
    public int getCount() {
        return khoanthuList.size();
    }

    @Override
    public Object getItem(int position) {
        return khoanthuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_thongke, parent, false);
        TextView textView = view.findViewById(R.id.tvthongke);
        textView.setText(khoanthuList.get(position).getKhoanthu());
        return  view;    }
}
