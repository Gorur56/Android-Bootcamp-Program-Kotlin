package com.firstapp.kisileruygulamasi.data.datasource

import android.util.Log

class KisilerDataSource {
    suspend fun kaydet(kisi_ad:String, kisi_tel:String)
    {
        Log.e("Kisi Kaydet","$kisi_ad - $kisi_tel")
    }
}