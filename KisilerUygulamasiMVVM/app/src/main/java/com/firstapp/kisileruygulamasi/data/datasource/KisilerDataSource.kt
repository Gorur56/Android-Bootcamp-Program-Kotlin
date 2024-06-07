package com.firstapp.kisileruygulamasi.data.datasource

import android.util.Log

class KisilerDataSource {
    suspend fun kaydet(kisi_ad:String, kisi_tel:String)
    {
        Log.e("Kisi Kaydet","$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id:Int, kisi_ad: String, kisi_tel: String)
    {
        Log.e("Kişi Kaydet", "$kisi_id, $kisi_ad, $kisi_tel")
    }

    suspend fun sil(kisi_id: Int)
    {
        Log.e("Kişi Sil", "$kisi_id")
    }
}