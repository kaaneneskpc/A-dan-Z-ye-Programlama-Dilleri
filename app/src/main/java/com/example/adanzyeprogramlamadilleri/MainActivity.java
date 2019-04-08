package com.example.adanzyeprogramlamadilleri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
private RecyclerView kategorirv;
private ArrayList<Kategori> kategoriArrayList;
private KategoriAdapter adapter;
private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-1185334412119164~9623459294");
        toolbar=findViewById(R.id.toolbar);
        kategorirv=findViewById(R.id.kategorirv);
        VeritabaniKopyala();
        vt=new Veritabani(this);

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        kategorirv.setHasFixedSize(true);
        kategorirv.setLayoutManager(new LinearLayoutManager(this));

        kategoriArrayList=new KategoriDao().tumkategoriler(vt);

        adapter=new KategoriAdapter(this,kategoriArrayList);
        kategorirv.setAdapter(adapter);

    }
    public void VeritabaniKopyala(){
        DatabaseCopyHelper helper=new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();

    }
}
