package com.example.hiltkullanimi

import android.util.Log

class Kargo {
    val adres = Adres("Kadıköy / Istanbul")

    fun gonder(){
        Log.e("Sonuc","Kargo ${adres.adresBilgisi} adresine gönderildi.")
    }
}