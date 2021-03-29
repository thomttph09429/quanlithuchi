package com.poly.ass1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.poly.ass1.model.Loaithu;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuSQL extends SQLiteOpenHelper {
    public static final String table_name = "thu";
    public static final String column_loaithu = "loaithu";


    public LoaiThuSQL(Context context) {
        super(context, "loaithuthu.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + table_name + " (" + column_loaithu + " text primary key)";
        db.execSQL(create_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(Loaithu loaithu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_loaithu, loaithu.getLoaithu());
        long kq = sqLiteDatabase.insert(table_name, null, contentValues);
        return kq;
    }

    public long update(String idthu, Loaithu loaithu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_loaithu, loaithu.getLoaithu());
        long kq = sqLiteDatabase.update(table_name, contentValues, column_loaithu + "=?",new String[]{idthu} );
        return kq;
    }

    public long delete(String loaithu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long kq = sqLiteDatabase.delete(table_name, column_loaithu + "=?",new String[]{loaithu} );
        return kq;

    }
    public List<Loaithu> getallloaithu(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<Loaithu> loaithuList = new ArrayList<>();
        String all = "SELECT*FROM "+table_name;
       Cursor cursor= sqLiteDatabase.rawQuery(all,null);
       if(cursor.getCount()>0){
           cursor.moveToFirst();

           while (!cursor.isAfterLast()){
               String textloaithu= cursor.getString(cursor.getColumnIndex(column_loaithu));
               Loaithu loaithu = new Loaithu();
                loaithu.setLoaithu(textloaithu);
                loaithuList.add(loaithu);
                cursor.moveToNext();


           }
           cursor.close();
       }
       return  loaithuList;




    }


}
