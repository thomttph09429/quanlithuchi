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

import androidx.fragment.app.Fragment;

import com.poly.ass1.Fragment.Fragment_loaithu;
import com.poly.ass1.MainActivity;
import com.poly.ass1.R;
import com.poly.ass1.model.Loaithu;
import com.poly.ass1.sql.LoaiThuSQL;

import java.util.List;

public class LoaiThuAdapter extends BaseAdapter {
    Context context;
    AlertDialog alertDialog;
    List<Loaithu> loaithuList;
    LoaiThuSQL loaiThuSQL;

    public LoaiThuAdapter(Context context, List<Loaithu> loaithuList) {
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
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        loaiThuSQL = new LoaiThuSQL(context);
        View view = LayoutInflater.from(context).inflate(R.layout.listview_loaithu, parent, false);
        TextView tvloaithu = view.findViewById(R.id.tvloaithu);
        tvloaithu.setText(loaithuList.get(position).getLoaithu());

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
                editTextcapnhat.setText(loaithuList.get(position).getLoaithu());
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtcapnhat = editTextcapnhat.getText().toString().trim();
                        if (stringedtcapnhat.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {


                            String id = loaithuList.get(position).getLoaithu();
                            Loaithu loaithu = new Loaithu();
                            loaithu.setLoaithu(editTextcapnhat.getText().toString());
                            long kq = loaiThuSQL.update(id, loaithu);


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
                editTextcapnhat.setText(loaithuList.get(position).getLoaithu());
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stringedtcapnhat = editTextcapnhat.getText().toString().trim();
                        if (stringedtcapnhat.isEmpty()) {
                            Toast.makeText(context, "không được để trống", Toast.LENGTH_SHORT).show();

                        } else {


                            Loaithu loaithu = new Loaithu();
                            loaithu.setLoaithu(editTextcapnhat.getText().toString());
                            long kq = loaiThuSQL.delete(loaithu.getLoaithu());


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
