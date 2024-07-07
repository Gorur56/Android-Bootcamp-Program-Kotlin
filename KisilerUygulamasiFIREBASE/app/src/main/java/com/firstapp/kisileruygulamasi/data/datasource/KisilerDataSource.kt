package com.firstapp.kisileruygulamasi.data.datasource

import android.util.Log
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {
    fun kisiYukle() : List<Kisiler> {
        return listOf()
    }

    fun ara(aramaKelimesi:String) : List<Kisiler> {
        return listOf()
    }

    fun kaydet(kisi_ad:String, kisi_tel:String)
    {
        Log.e("Kisi Kaydet","$kisi_ad - $kisi_tel")
    }

    fun guncelle(kisi_id:String, kisi_ad: String, kisi_tel: String)
    {
        Log.e("Kişi Kaydet", "$kisi_id, $kisi_ad, $kisi_tel")
    }

    fun sil(kisi_id: String)
    {
        Log.e("Kişi Sil", "$kisi_id")
    }
}