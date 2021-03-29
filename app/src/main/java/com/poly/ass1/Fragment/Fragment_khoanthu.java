package com.poly.ass1.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.ass1.R;
import com.poly.ass1.adapter.KhoanThuAdapter;
import com.poly.ass1.model.Khoanthu;
import com.poly.ass1.model.Loaithu;
import com.poly.ass1.sql.KhoanThuSQL;

import java.util.List;


public class Fragment_khoanthu extends Fragment {
    FloatingActionButton floatingActionButton;
    KhoanThuSQL khoanThuSQL;
    KhoanThuAdapter khoanThuAdapter;
    ListView lvkhoanthu;
    AlertDialog alertDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_khoanthu, container, false);
        khoanThuSQL = new KhoanThuSQL(getActivity());

        lvkhoanthu = view.findViewById(R.id.lvkhoanthu);
         final List<Khoanthu> khoanthuList = khoanThuSQL.getallkhoanthu();
        khoanThuAdapter = new KhoanThuAdapter(getActivity(), khoanthuList);
        lvkhoanthu.setAdapter(khoanThuAdapter);


        floatingActionButton = view.findViewById(R.id.floatbuttonKhoanthu);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_thu, null);
                builder.setView(view1);
                final EditText edtkhoanthu = view1.findViewById(R.id.edtthu);
                final Button btnkhoanthu = view1.findViewById(R.id.btnthu);
                btnkhoanthu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringkhoanthu = edtkhoanthu.getText().toString().trim();
                        if (stringkhoanthu.isEmpty()) {
                            Toast.makeText(getActivity(), "yêu cầu nhập khoản thu", Toast.LENGTH_SHORT).show();

                        } else {
                            Khoanthu khoanthu = new Khoanthu();
                            khoanthu.setKhoanthu(edtkhoanthu.getText().toString());
                            long kq = khoanThuSQL.insert(khoanthu);
                            if (kq > 0) {
                                Toast.makeText(getActivity(), "thêm thành công", Toast.LENGTH_SHORT).show();

                                lvkhoanthu = view.findViewById(R.id.lvkhoanthu);
                                List<Khoanthu> khoanthuList = khoanThuSQL.getallkhoanthu();
                                khoanThuAdapter = new KhoanThuAdapter(getActivity(), khoanthuList);
                                lvkhoanthu.setAdapter(khoanThuAdapter);
                            } else {
                                Toast.makeText(getActivity(), "thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }
                });


                builder.create();
                builder.show();
            }
        });
        return view;
    }
}
