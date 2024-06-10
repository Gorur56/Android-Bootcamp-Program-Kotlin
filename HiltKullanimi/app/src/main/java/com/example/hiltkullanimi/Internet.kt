package com.example.hiltkullanimi

import android.util.Log

class Internet {
    val adres = Adres("Kadıköy / Istanbul")

    fun basvuruYap(){
        Log.e("Sonuc","Internet bavurusu ${adres.adresBilgisi} adresine yapıldı")
    }
}