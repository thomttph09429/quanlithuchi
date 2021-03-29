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

import com.poly.ass1.Fragment.Fragment_LoaiChi;
import com.poly.ass1.MainActivity;
import com.poly.ass1.R;
import com.poly.ass1.model.LoaiChi;
import com.poly.ass1.sql.LoaiChiSQL;

import java.util.List;

public class LoaiChiAdapter extends BaseAdapter {
    List<LoaiChi> loaiChiList;
    Context context;
    LoaiChiSQL loaiChiSQL;
    LoaiChiAdapter loaiChiAdapter;
    AlertDialog alertDialog;

    public LoaiChiAdapter(Context context, List<LoaiChi> loaiChiList) {
        this.context = context;
        this.loaiChiList = loaiChiList;

    }

//

    @Override
    public int getCount() {
        return loaiChiList.size();
    }

    @Override
    public Object getItem(int position) {
        return loaiChiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        loaiChiSQL = new LoaiChiSQL(context);
        View view = LayoutInflater.from(context).inflate(R.layout.listview_loaichi, parent, false);
        TextView tvloaichi = view.findViewById(R.id.rvloaichi);
        tvloaichi.setText(loaiChiList.get(position).getLoaichi());

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
                editTextcapnhat.setText(loaiChiList.get(position).getLoaichi());

                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtcapnhat = editTextcapnhat.getText().toString().trim();
                        if (stringedtcapnhat.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {


                            String idloaichi = loaiChiList.get(position).getLoaichi();
                            LoaiChi loaiChi = new LoaiChi();
                            loaiChi.setLoaichi(editTextcapnhat.getText().toString());
                            long kq = loaiChiSQL.update(idloaichi, loaiChi);


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
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_delete, null);
                builder.setView(view1);
                final Button btnxacnhan = view1.findViewById(R.id.btnxacnhan);
                final EditText editTextcapnhat = view1.findViewById(R.id.edtdelete);
                editTextcapnhat.setText(loaiChiList.get(position).getLoaichi());
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtcapnhat = editTextcapnhat.getText().toString().trim();
                        if (stringedtcapnhat.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {


                            LoaiChi loaithu = new LoaiChi();
                            loaithu.setLoaichi(editTextcapnhat.getText().toString());
                            long kq = loaiChiSQL.delete(loaithu.getLoaichi());


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
