package com.example.adanzyeprogramlamadilleri;

import java.io.Serializable;

public class Yazilim implements Serializable {
    private int yazilim_id;
    private String yazilim_ad;
    private String yazilim_icerik;
    private Kategori kategori;

    public Yazilim() {
    }

    public Yazilim(int yazilim_id, String yazilim_ad, String yazilim_icerik,  Kategori kategori) {
        this.yazilim_id = yazilim_id;
        this.yazilim_ad = yazilim_ad;
        this.yazilim_icerik = yazilim_icerik;
        this.kategori = kategori;
    }

    public int getYazilim_id() {
        return yazilim_id;
    }

    public void setYazilim_id(int yazilim_id) {
        this.yazilim_id = yazilim_id;
    }

    public String getYazilim_ad() {
        return yazilim_ad;
    }

    public void setYazilim_ad(String yazilim_ad) {
        this.yazilim_ad = yazilim_ad;
    }

    public String getYazilim_icerik() {
        return yazilim_icerik;
    }

    public void setYazilim_icerik(String yazilim_icerik) {
        this.yazilim_icerik = yazilim_icerik;
    }


    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
}
