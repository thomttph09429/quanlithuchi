package com.poly.ass1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.poly.ass1.model.LoaiChi;

import java.util.ArrayList;
import java.util.List;

public class LoaiChiSQL extends SQLiteOpenHelper {
    public static final String table_name = "chi";
    public static final String column_loaichi = "loaichi";

    public LoaiChiSQL( Context context) {
        super(context, "chi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + table_name + " (" + column_loaichi + " text primary key)";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(LoaiChi loaiChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_loaichi, loaiChi.getLoaichi());
        long kq = sqLiteDatabase.insert(table_name, null, contentValues);
        return kq;
    }

    public long update(String idloaichi,LoaiChi loaiChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_loaichi, loaiChi.getIdloaichi());
        long kq = sqLiteDatabase.update(table_name, contentValues, column_loaichi + "=?",new String[]{idloaichi} );
        return kq;
    }

    public long delete(String loaithu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long kq = sqLiteDatabase.delete(table_name, column_loaichi + "=?",new String[]{loaithu} );
        return kq;

    }
    public List<LoaiChi> getallloaichi(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<LoaiChi> loaiChiList = new ArrayList<>();
        String all = "SELECT*FROM "+table_name;
        Cursor cursor= sqLiteDatabase.rawQuery(all,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();

            while (!cursor.isAfterLast()){
                String textloaichi= cursor.getString(cursor.getColumnIndex(column_loaichi));
                LoaiChi loaiChi = new LoaiChi();
                loaiChi.setLoaichi(textloaichi);
                loaiChiList.add(loaiChi);
                cursor.moveToNext();


            }
            cursor.close();
        }
        return  loaiChiList;




    }
}
