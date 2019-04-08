package com.example.adanzyeprogramlamadilleri;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class YazilimAdapter extends RecyclerView.Adapter<YazilimAdapter.CardTasarimTutucu> {
    private Context mcontext;
    private List<Yazilim> yazilimListe;

    public YazilimAdapter(Context mcontext, List<Yazilim> yazilimListe) {
        this.mcontext = mcontext;
        this.yazilimListe = yazilimListe;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView yazilim_card;
        private TextView textViewYazilimAd;
        private ImageView imageViewYazilimResim;
        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            yazilim_card=itemView.findViewById(R.id.yazilim_card);
            textViewYazilimAd=itemView.findViewById(R.id.textViewYazilimAd);

        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yazilim_card_tasarim,viewGroup,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu cardTasarimTutucu, int i) {
        final Yazilim yazilim=yazilimListe.get(i);
        cardTasarimTutucu.textViewYazilimAd.setText(yazilim.getYazilim_ad());
        cardTasarimTutucu.yazilim_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(mcontext ,DetayActivity.class);
                i1.putExtra("nesne",yazilim);
                mcontext.startActivity(i1);
            }
        });
    }
    @Override
    public int getItemCount() {
        return yazilimListe.size();
    }

}
