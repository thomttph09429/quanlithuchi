package com.poly.ass1.ui.thong_ke;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.poly.ass1.R;
import com.poly.ass1.adapter.KhoanChiAdapter;
import com.poly.ass1.adapter.KhoanThuAdapter;
import com.poly.ass1.adapter.LoaiChiAdapter;
import com.poly.ass1.adapter.LoaiThuAdapter;
import com.poly.ass1.adapter.ThongKE_Loaichi_Adapter;
import com.poly.ass1.adapter.ThongKe_KhoanChi_Adapter;
import com.poly.ass1.adapter.ThongKe_Khoanthu_adapter;
import com.poly.ass1.adapter.ThongKe_loaithu_Adapter;
import com.poly.ass1.model.KhoanChi;
import com.poly.ass1.model.Khoanthu;
import com.poly.ass1.model.LoaiChi;
import com.poly.ass1.model.Loaithu;
import com.poly.ass1.sql.KhoanChiSQL;
import com.poly.ass1.sql.KhoanThuSQL;
import com.poly.ass1.sql.LoaiChiSQL;
import com.poly.ass1.sql.LoaiThuSQL;

import java.util.List;

public class thongke_Fragment extends Fragment {
    KhoanChiAdapter khoanChiAdapter;
    KhoanThuAdapter khoanThuAdapter;
    LoaiChiAdapter loaiChiAdapter;
    LoaiThuAdapter loaiThuAdapter;

    KhoanChiSQL khoanChiSQL;
    KhoanThuSQL khoanThuSQL;
    LoaiChiSQL loaiChiSQL;
    LoaiThuSQL loaiThuSQL;

    ThongKe_loaithu_Adapter thongKe_loaithu_adapter;
    ThongKE_Loaichi_Adapter thongKE_loaichi_adapter;
    ThongKe_KhoanChi_Adapter thongKe_khoanChi_adapter;
    ThongKe_Khoanthu_adapter thongKe_khoanthu_adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);


        loaiThuSQL = new LoaiThuSQL(getActivity());
        List<Loaithu> loaithuList = loaiThuSQL.getallloaithu();
        thongKe_loaithu_adapter = new ThongKe_loaithu_Adapter(getActivity(),loaithuList);
        ListView listView = view.findViewById(R.id.lvloaithu);
        listView.setAdapter(thongKe_loaithu_adapter);



        loaiChiSQL = new LoaiChiSQL(getActivity());
        List<LoaiChi> loaiChiList = loaiChiSQL.getallloaichi();
        thongKE_loaichi_adapter = new ThongKE_Loaichi_Adapter(getActivity(),loaiChiList);
        ListView listView1 = view.findViewById(R.id.lvloaichi);
        listView1.setAdapter(thongKe_loaithu_adapter);



        khoanChiSQL = new KhoanChiSQL(getActivity());
        List<KhoanChi> khoanChiList = khoanChiSQL.getallkhoanchi();
        thongKe_khoanChi_adapter = new ThongKe_KhoanChi_Adapter(getActivity(),khoanChiList);
        ListView listView2 = view.findViewById(R.id.lvkhoanchi);
        listView2.setAdapter(thongKe_khoanChi_adapter);





        khoanThuSQL = new KhoanThuSQL(getActivity());
        List<Khoanthu> khoanthuList = khoanThuSQL.getallkhoanthu();
        thongKe_khoanthu_adapter = new ThongKe_Khoanthu_adapter(getActivity(),khoanthuList);
        ListView listView3 = view.findViewById(R.id.lvkhoanthu);
        listView3.setAdapter(thongKe_khoanthu_adapter);
        return view;
    }
}
