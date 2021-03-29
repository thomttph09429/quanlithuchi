package com.poly.ass1.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.ass1.R;
import com.poly.ass1.model.Khoanthu;
import com.poly.ass1.sql.KhoanThuSQL;

import java.util.List;

public class KhoanThuAdapter extends BaseAdapter {
    Context context;
    KhoanThuSQL khoanThuSQL;
    List<Khoanthu> khoanthuList;
    KhoanThuAdapter khoanThuAdapter;
    AlertDialog alertDialog;

    public KhoanThuAdapter(Context context, List<Khoanthu> khoanthuList) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        khoanThuSQL = new KhoanThuSQL(context);
        View view = LayoutInflater.from(context).inflate(R.layout.listview_khoanthu, parent, false);
        TextView tvkhoanthu = view.findViewById(R.id.tvkhoanthu);
        tvkhoanthu.setText(khoanthuList.get(position).getKhoanthu());
        ImageView imgupdate = view.findViewById(R.id.imgupdate);
        ImageView imgdelete = view.findViewById(R.id.imvdelete);
        imgupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_update, null);
                builder.setView(view1);
                final EditText edtcapnhat = view1.findViewById(R.id.edtcapnhat);
                edtcapnhat.setText(khoanthuList.get(position).getKhoanthu());
                Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtthu = edtcapnhat.getText().toString().trim();
                        if (stringedtthu.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();
                        } else {
                            String idkhaonthu = khoanthuList.get(position).getKhoanthu();
                            Khoanthu khoanthu = new Khoanthu();
                            khoanthu.setKhoanthu(edtcapnhat.getText().toString());
                            long kq = khoanThuSQL.update(idkhaonthu,khoanthu);
                            if (kq > 0) {
                                Toast.makeText(context, "sửa thành công", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(context, "sửa thất bại", Toast.LENGTH_SHORT).show();

                            }


                        }

                    }
                });



                builder.create();
                builder.show();

            }
        });


        imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_delete, null);
                builder.setView(view1);
                final EditText edtdelete = view1.findViewById(R.id.edtdelete);
                Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                edtdelete.setText(khoanthuList.get(position).getKhoanthu());
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtdelete = edtdelete.getText().toString();
                        if (stringedtdelete.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {
                            Khoanthu khoanthu = new Khoanthu();
                            khoanthu.setKhoanthu(edtdelete.getText().toString());
                            long kq = khoanThuSQL.delete(khoanthu.getKhoanthu());


                            if (kq > 0) {


                                Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(context, "xóa thất bại", Toast.LENGTH_SHORT).show();

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
