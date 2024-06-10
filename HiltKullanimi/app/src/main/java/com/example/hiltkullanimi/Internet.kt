package com.example.hiltkullanimi

import android.location.Address
import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor( var adres: Adres) {
    //val adres = Adres("Kadıköy / Istanbul") //Hilt ile kullanacağız.

    fun basvuruYap(){
        Log.e("Sonuc","Internet bavurusu ${adres.adresBilgisi} adresine yapıldı")
    }
}