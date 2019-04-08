package com.example.adanzyeprogramlamadilleri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper {
    public Veritabani(Context context) {
        super(context, "yazilimdili.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS \"kategori\" (\n" +
                "\t\"kategori_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"kategori_ad\"\tTEXT\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS \"yazilim\" (\n" +
                "\t\"yazilim_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"yazilim_ad\"\tTEXT,\n" +
                "\t\"yazilim_icerik\"\tTEXT,\n" +
                "\t\"kategori_id\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"kategori_id\") REFERENCES \"kategori\"(\"kategori_id\")\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS kategori");
        db.execSQL("DROP TABLE IF EXISTS yazilim");
        onCreate(db);
    }
}
