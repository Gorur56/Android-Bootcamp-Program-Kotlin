package com.example.hiltkullanimi

import android.util.Log
import javax.inject.Inject

class Kargo @Inject constructor( var adres: Adres){
    //val adres = Adres("Kadıköy / Istanbul") //Hilt ile alacağız.

    fun gonder(){
        Log.e("Sonuc","Kargo ${adres.adresBilgisi} adresine gönderildi.")
    }
}