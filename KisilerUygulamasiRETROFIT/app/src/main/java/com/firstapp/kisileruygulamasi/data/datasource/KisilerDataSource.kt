package com.firstapp.kisileruygulamasi.data.datasource

import android.util.Log
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao:KisilerDao) {
    suspend fun kisiYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            /* Verileri servisten çekeceğiz.*/

            return@withContext kdao.kisileriYukle().kisiler //Webservisten kişi listesini getirir.
        }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> =
        withContext(Dispatchers.IO) {
            val kisilerlistesi = ArrayList<Kisiler>()

            val k1 = Kisiler(1, "Ahmet", "523634896")
            kisilerlistesi.add(k1)

            return@withContext kisilerlistesi
        }
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