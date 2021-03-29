package com.poly.ass1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.constraintlayout.widget.ConstraintLayout;

import com.poly.ass1.model.Khoanthu;

import java.util.ArrayList;
import java.util.List;

public class KhoanThuSQL extends SQLiteOpenHelper {
    public static final String table_name = "thu";
    public static final String column_khoanthu = "khoanthu";

    public KhoanThuSQL(Context context) {
        super(context, "khoanthuthu.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + table_name + " (" + column_khoanthu + " text primary key)";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public long insert(Khoanthu khoanthu) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_khoanthu, khoanthu.getKhoanthu());
        long kq = sqLiteDatabase.insert(table_name,null, contentValues);
        return  kq;

    }

    public long update(String idkhoanthu, Khoanthu khoanthu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_khoanthu, khoanthu.getKhoanthu());
        long kq = sqLiteDatabase.update(table_name, contentValues, column_khoanthu + "=?", new String[]{idkhoanthu});
        return kq;
    }

    public long delete(String khoanthu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long kq = sqLiteDatabase.delete(table_name, column_khoanthu + "=?", new String[]{khoanthu});
        return kq;

    }

    public List<Khoanthu> getallkhoanthu() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<Khoanthu> khoanthuList = new ArrayList<>();
        String all = "SELECT*FROM " + table_name;
        Cursor cursor = sqLiteDatabase.rawQuery(all, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                String textkhoanthu = cursor.getString(cursor.getColumnIndex(column_khoanthu));
                Khoanthu khoanthu = new Khoanthu();
                khoanthu.setKhoanthu(textkhoanthu);
                khoanthuList.add(khoanthu);
                cursor.moveToNext();


            }
            cursor.close();
        }
        return khoanthuList;


    }
}
