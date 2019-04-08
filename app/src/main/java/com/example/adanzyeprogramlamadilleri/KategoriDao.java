package com.example.adanzyeprogramlamadilleri;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {
    public ArrayList<Kategori> tumkategoriler(Veritabani vt){
        ArrayList<Kategori> kategoriArrayList=new ArrayList<>();

        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM kategori",null);

        while (c.moveToNext()){
            Kategori k=new Kategori(c.getInt(c.getColumnIndex("kategori_id")),
                    c.getString(c.getColumnIndex("kategori_ad")));
            kategoriArrayList.add(k);
        }
        return kategoriArrayList;
    }
}
