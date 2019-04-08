package com.example.adanzyeprogramlamadilleri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView textViewyazilimad,textViewicerik;
private Yazilim yazilim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textViewyazilimad=findViewById(R.id.textViewyazilimad);
        textViewicerik=findViewById(R.id.textViewicerik);

        yazilim=(Yazilim)getIntent().getSerializableExtra("nesne");
        textViewyazilimad.setText(yazilim.getYazilim_ad());
        textViewicerik.setText(yazilim.getYazilim_icerik());

    }
}
