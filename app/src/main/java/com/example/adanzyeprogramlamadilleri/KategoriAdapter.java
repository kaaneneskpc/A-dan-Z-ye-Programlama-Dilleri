package com.example.adanzyeprogramlamadilleri;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu> {
    private Context mcontext;
    private List<Kategori> kategoriListe;

    public KategoriAdapter(Context mcontext, List<Kategori> kategoriListe) {
        this.mcontext = mcontext;
        this.kategoriListe = kategoriListe;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView kategori_card;
        private TextView textView_kategori_ad;
        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            kategori_card=itemView.findViewById(R.id.kategori_card);
            textView_kategori_ad=itemView.findViewById(R.id.textView_kategori_ad);
        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kategori_card_tasarim,viewGroup,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu cardTasarimTutucu, int i) {
        final Kategori kategori=kategoriListe.get(i);
        cardTasarimTutucu.textView_kategori_ad.setText(kategori.getKategori_ad());
        cardTasarimTutucu.kategori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(mcontext ,YazilimDilleriActivity.class);
                i1.putExtra("kategori_nesne",kategori);
                mcontext.startActivity(i1);
            }
        });
    }
    @Override
    public int getItemCount() {
        return kategoriListe.size();
    }

}
