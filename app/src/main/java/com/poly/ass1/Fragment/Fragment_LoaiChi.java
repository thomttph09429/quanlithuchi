package com.poly.ass1.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.ass1.R;
import com.poly.ass1.adapter.LoaiChiAdapter;
import com.poly.ass1.model.LoaiChi;
import com.poly.ass1.sql.LoaiChiSQL;

import java.util.List;

public class Fragment_LoaiChi extends Fragment {
    FloatingActionButton floatingActionButton;
    LoaiChiSQL loaiChiSQL;
    LoaiChiAdapter loaiChiAdapter;
    AlertDialog alertDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loaiChiSQL = new LoaiChiSQL(getActivity());
        View view = inflater.inflate(R.layout.fragment_loaichi, container, false);

        final ListView listView = view.findViewById(R.id.lvloaichi);
        List<LoaiChi> loaiChiList = loaiChiSQL.getallloaichi();
        loaiChiAdapter = new LoaiChiAdapter(getActivity(), loaiChiList);
        listView.setAdapter(loaiChiAdapter);


        floatingActionButton = view.findViewById(R.id.floatbuttonloaichi);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_chi, null);
                builder.setView(view1);
                final EditText edtloaichi = view1.findViewById(R.id.edtchi);
                Button btnloaichi = view1.findViewById(R.id.btnchi);
                btnloaichi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringloaichi = edtloaichi.getText().toString().trim();

                        if (stringloaichi.isEmpty()) {
                            Toast.makeText(getActivity(), "yêu cầu nhập loại chi", Toast.LENGTH_SHORT).show();

                        } else {
                            LoaiChi loaiChi = new LoaiChi();
                            loaiChi.setLoaichi(edtloaichi.getText().toString());
                            long kq = loaiChiSQL.insert(loaiChi);
                            if (kq > 0) {
                                List<LoaiChi> loaiChiList = loaiChiSQL.getallloaichi();
                                loaiChiAdapter = new LoaiChiAdapter(getActivity(), loaiChiList);
                                listView.setAdapter(loaiChiAdapter);
                                Toast.makeText(getActivity(), "thêm thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "thêm thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                        alertDialog.dismiss();
                    }
                });

           alertDialog=     builder.create();
             alertDialog =   builder.show();
            }
        });
        return view;
    }
}
