package com.poly.ass1.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.ass1.R;
import com.poly.ass1.adapter.LoaiThuAdapter;
import com.poly.ass1.model.Loaithu;
import com.poly.ass1.sql.LoaiThuSQL;

import java.util.List;

public class Fragment_loaithu extends Fragment {
    public FloatingActionButton floatingActionButton;
    AlertDialog alertDialog;
    LoaiThuSQL loaiThuSQL;
    ListView lvloaithu;
    LoaiThuAdapter loaiThuAdapter;
    AlertDialog alertDialog1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        loaiThuSQL = new LoaiThuSQL(getActivity());
        final View view = inflater.inflate(R.layout.fragment_loaithu, container, false);

        lvloaithu = view.findViewById(R.id.lvloaithu);
        final List<Loaithu> loaithuList = loaiThuSQL.getallloaithu();
        loaiThuAdapter = new LoaiThuAdapter(getActivity(), loaithuList);
        lvloaithu.setAdapter(loaiThuAdapter);


        floatingActionButton = view.findViewById(R.id.floatbuttonLOAITHU);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_thu, null);
                builder.setView(view1);
                final EditText edtloaithu = view1.findViewById(R.id.edtthu);
                final Button btnkhoanthu = view1.findViewById(R.id.btnthu);
                final Button btnhuy = view1.findViewById(R.id.btnhuy);
                btnkhoanthu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringloaithu = edtloaithu.getText().toString().trim();
                        if (stringloaithu.isEmpty()) {
                            Toast.makeText(getActivity(), "yêu cầu nhập loại thu", Toast.LENGTH_SHORT).show();
                        } else {
                            Loaithu loaithu = new Loaithu();
                            loaithu.setLoaithu(edtloaithu.getText().toString());
                            long kq = loaiThuSQL.insert(loaithu);
                            if (kq > 0) {
                                Toast.makeText(getActivity(), "thêm thành công", Toast.LENGTH_SHORT).show();
                                lvloaithu = view.findViewById(R.id.lvloaithu);
                                List<Loaithu> loaithuList = loaiThuSQL.getallloaithu();
                                loaiThuAdapter = new LoaiThuAdapter(getActivity(), loaithuList);
                                lvloaithu.setAdapter(loaiThuAdapter);


                            } else {
                                Toast.makeText(getActivity(), "thêm thất bại", Toast.LENGTH_SHORT).show();
                            }

                        }
                        alertDialog.dismiss();

                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

              alertDialog=  builder.create();
             alertDialog=   builder.show();

            }

        });

        return view;
    }


}
