package com.poly.ass1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poly.ass1.R;
import com.poly.ass1.model.KhoanChi;

import java.util.List;

public class ThongKe_KhoanChi_Adapter extends BaseAdapter {
    List<KhoanChi> khoanChiList;
    Context context;
    public ThongKe_KhoanChi_Adapter(Context context, List<KhoanChi> khoanChiList) {
        this.context = context;
        this.khoanChiList = khoanChiList;
    }

    @Override
    public int getCount() {
        return khoanChiList.size();
    }

    @Override
    public Object getItem(int position) {
        return khoanChiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_thongke, parent, false);
        TextView textView = view.findViewById(R.id.tvthongke);
        textView.setText(khoanChiList.get(position).getKhoanchi());
        return  view;
    }
}
