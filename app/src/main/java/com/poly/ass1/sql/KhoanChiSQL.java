package com.poly.ass1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.poly.ass1.model.KhoanChi;

import java.util.ArrayList;
import java.util.List;

public class KhoanChiSQL extends SQLiteOpenHelper {
    public static final String table_name = "chi";
    public static final String column_khoanchi = "khoanchi";
    public KhoanChiSQL( Context context) {
        super(context, "khoanchi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + table_name + " (" + column_khoanchi + " text primary key)";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(KhoanChi khoanChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_khoanchi, khoanChi.getKhoanchi());
        long kq = sqLiteDatabase.insert(table_name, null, contentValues);
        return kq;
    }

    public long update(String idkhoanchi ,KhoanChi khoanChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_khoanchi, khoanChi.getKhoanchi());
        long kq = sqLiteDatabase.update(table_name, contentValues, column_khoanchi + "=?",new String[]{idkhoanchi} );
        return kq;
    }

    public long delete(String khoanchi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long kq = sqLiteDatabase.delete(table_name, column_khoanchi + "=?",new String[]{khoanchi} );
        return kq;

    }
    public List<KhoanChi> getallkhoanchi(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<KhoanChi> khoanChiList = new ArrayList<>();
        String all = "SELECT*FROM "+table_name;
        Cursor cursor= sqLiteDatabase.rawQuery(all,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();

            while (!cursor.isAfterLast()){
                String textkhoanchi= cursor.getString(cursor.getColumnIndex(column_khoanchi));
                KhoanChi khoanChi = new KhoanChi();
                khoanChi.setKhoanchi(textkhoanchi);
                khoanChiList.add(khoanChi);
                cursor.moveToNext();


            }
            cursor.close();
        }
        return  khoanChiList;




    }
}
