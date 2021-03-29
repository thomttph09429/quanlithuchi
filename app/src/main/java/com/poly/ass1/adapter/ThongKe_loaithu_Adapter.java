package com.poly.ass1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.poly.ass1.R;
import com.poly.ass1.model.Loaithu;

import java.util.List;

public class ThongKe_loaithu_Adapter extends BaseAdapter {
    List<Loaithu> loaithuList;
    Context context;
    public ThongKe_loaithu_Adapter(Context context, List<Loaithu> loaithuList) {
        this.context = context;
        this.loaithuList = loaithuList;
    }

    @Override
    public int getCount() {
        return loaithuList.size();
    }

    @Override
    public Object getItem(int position) {
        return loaithuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_thongke, parent, false);
        TextView textView = view.findViewById(R.id.tvthongke);
        textView.setText(loaithuList.get(position).getLoaithu());
        return  view;
    }
}
