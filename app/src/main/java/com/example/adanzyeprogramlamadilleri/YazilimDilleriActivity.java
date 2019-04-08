package com.example.adanzyeprogramlamadilleri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class YazilimDilleriActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView yazilim_dillerirv;
    private ArrayList<Yazilim> yazilimArrayList;
    private YazilimAdapter adapter;
    private Kategori kategori;
    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yazilim_dilleri);
        toolbar2=findViewById(R.id.toolbar);
        yazilim_dillerirv=findViewById(R.id.yazilim_dillerirv);
        toolbar2.setTitle("Yazilim Dilleri");
        setSupportActionBar(toolbar2);
        vt=new Veritabani(this);
        kategori=(Kategori)getIntent().getSerializableExtra("kategori_nesne");

        yazilimArrayList=new YazilimDao().tumYazilimlarByKategoriId(vt,kategori.getKategori_id());

        yazilim_dillerirv.setHasFixedSize(true);
        yazilim_dillerirv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapter=new YazilimAdapter(this,yazilimArrayList);
        yazilim_dillerirv.setAdapter(adapter);


    }
}
