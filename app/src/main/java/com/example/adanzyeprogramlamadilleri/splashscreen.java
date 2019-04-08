package com.example.adanzyeprogramlamadilleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {
    private static int gosterim_suresi = 2000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splashscreen);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(i);

                    finish();
                }
            }, gosterim_suresi);
        }
}
