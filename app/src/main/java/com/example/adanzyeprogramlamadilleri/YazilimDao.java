package com.example.adanzyeprogramlamadilleri;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class YazilimDao {

        public ArrayList<Yazilim> tumYazilimlarByKategoriId(Veritabani vt,int kategori_id){
            ArrayList<Yazilim> yazilimArrayList=new ArrayList<>();

            SQLiteDatabase db=vt.getWritableDatabase();
            Cursor c=db.rawQuery("SELECT * FROM yazilim,kategori WHERE yazilim.kategori_id=kategori.kategori_id and yazilim.kategori_id="+kategori_id,null);
            while (c.moveToNext()){
                Kategori k=new Kategori(c.getInt(c.getColumnIndex("kategori_id")),
                        c.getString(c.getColumnIndex("kategori_ad")));
                Yazilim y=new Yazilim(c.getInt(c.getColumnIndex("yazilim_id")),
                        c.getString(c.getColumnIndex("yazilim_ad")),
                        c.getString(c.getColumnIndex("yazilim_icerik")),k);
                yazilimArrayList.add(y);
            }
            return yazilimArrayList;
        }

}
