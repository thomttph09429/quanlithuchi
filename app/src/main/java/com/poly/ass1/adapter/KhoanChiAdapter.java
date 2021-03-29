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
import android.widget.TextView;
import android.widget.Toast;

import com.poly.ass1.R;
import com.poly.ass1.model.KhoanChi;
import com.poly.ass1.sql.KhoanChiSQL;

import java.util.List;

public class KhoanChiAdapter extends BaseAdapter {
    KhoanChiSQL khoanChiSQL;
    List<KhoanChi> khoanChiList;
    Context context;

    public KhoanChiAdapter(Context context, List<KhoanChi> khoanChiList) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        khoanChiSQL = new KhoanChiSQL(context);
        View view = LayoutInflater.from(context).inflate(R.layout.listview_khoanchi, parent, false);
        TextView tvkhoanchi = view.findViewById(R.id.tvkhoanchi);
        tvkhoanchi.setText(khoanChiList.get(position).getKhoanchi());

        final ImageView imvupdate = view.findViewById(R.id.imgupdate);
        ImageView imgdelete = view.findViewById(R.id.imvdelete);
        imvupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_update, null);
                builder.setView(view1);
                final Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                final EditText editTextcapnhat = view1.findViewById(R.id.edtcapnhat);


                editTextcapnhat.setText(khoanChiList.get(position).getKhoanchi());

                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtcapnhat = editTextcapnhat.getText().toString().trim();
                        if (stringedtcapnhat.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {

                            String idkhoanchi = khoanChiList.get(position).getKhoanchi();
                            KhoanChi khoanChi = new KhoanChi();
                            khoanChi.setKhoanchi(editTextcapnhat.getText().toString());
                            long kq = khoanChiSQL.update(idkhoanchi, khoanChi);


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
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_delete, null);
                builder.setView(view1);
                final Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                final EditText editTextcapnhat = view1.findViewById(R.id.edtdelete);
                editTextcapnhat.setText(khoanChiList.get(position).getKhoanchi());
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtcapnhat = editTextcapnhat.getText().toString();
                        if (stringedtcapnhat.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {


                            KhoanChi loaithu = new KhoanChi();
                            loaithu.setKhoanchi(editTextcapnhat.getText().toString());
                            long kq = khoanChiSQL.delete(loaithu.getKhoanchi());


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
