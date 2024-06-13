package com.firstapp.kisileruygulamasi.data.datasource

import android.util.Log
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao: KisilerDao) {
    suspend fun kisiYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            /* Verileri servisten çekeceğiz.
            //İtem oluşturma için arrayList oluşturuyoruz.
            val kisilerListesi = ArrayList<Kisiler>()

            //Kişiler nesne oluştur
            val k1 = Kisiler(1, "Ahmet", "523634896")
            val k2 = Kisiler(2,"Mehmet","1234567852")
            val k3 = Kisiler(3,"Ayşe","5289634578")

            //Nesneleri arrayliste ekle
            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
            kisilerListesi.add(k3)*/

            return@withContext kdao.kisleriYukle().kisiler //Webservisten kişi listesini getirir.
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