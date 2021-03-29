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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.poly.ass1.R;
import com.poly.ass1.adapter.KhoanChiAdapter;
import com.poly.ass1.model.KhoanChi;
import com.poly.ass1.sql.KhoanChiSQL;

import java.util.List;

public class Fragment_KhoanChi extends Fragment {
    KhoanChiSQL khoanChiSQL;
    FloatingActionButton floatingActionButton;
    ListView lvkhoanchi;
    KhoanChiAdapter khoanChiAdapter;
    AlertDialog alertDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        khoanChiSQL = new KhoanChiSQL(getActivity());


        final View view = inflater.inflate(R.layout.fragment_khoanchi, container, false);
        lvkhoanchi = view.findViewById(R.id.lvkhoanchi);
        final List<KhoanChi> khoanthuList = khoanChiSQL.getallkhoanchi();
        khoanChiAdapter = new KhoanChiAdapter(getActivity(), khoanthuList);
        lvkhoanchi.setAdapter(khoanChiAdapter);


        floatingActionButton = view.findViewById(R.id.floatbuttonKhoanchi);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_chi, null);
                builder.setView(view1);
                final EditText edtkhoanchi = view1.findViewById(R.id.edtchi);
                Button btnkhoanchi = view1.findViewById(R.id.btnchi);
                btnkhoanchi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringkhoanthu = edtkhoanchi.getText().toString().trim();
                        if (stringkhoanthu.isEmpty()) {
                            Toast.makeText(getActivity(), "yêu cầu nhập khoản thu", Toast.LENGTH_SHORT).show();

                        } else {
                            KhoanChi khoanChi = new KhoanChi();
                            khoanChi.setKhoanchi(edtkhoanchi.getText().toString());
                            long kq = khoanChiSQL.insert(khoanChi);
                            if (kq > 0) {

                                List<KhoanChi>     khoanthuList = khoanChiSQL.getallkhoanchi();
                                khoanChiAdapter = new KhoanChiAdapter(getActivity(), khoanthuList);
                                lvkhoanchi.setAdapter(khoanChiAdapter);
                                Toast.makeText(getActivity(), "thêm thành công", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getActivity(), "thêm thất bại", Toast.LENGTH_SHORT).show();

                            }

                        }
                        alertDialog.dismiss();

                    }
                });



            alertDialog=    builder.create();
          alertDialog=      builder.show();

            }
        });

        return view;
    }
}
