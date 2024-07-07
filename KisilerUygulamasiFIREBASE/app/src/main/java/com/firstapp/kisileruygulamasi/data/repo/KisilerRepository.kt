package com.firstapp.kisileruygulamasi.data.repo

import com.firstapp.kisileruygulamasi.data.datasource.KisilerDataSource
import com.firstapp.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository( var kds:KisilerDataSource) {
    //var kds = KisilerDataSource()
    fun  kaydet(kisi_ad:String, kisi_tel:String) = kds.kaydet(kisi_ad,kisi_tel)

    fun guncelle(kisi_id:String, kisi_ad: String, kisi_tel: String) = kds.guncelle(kisi_id,kisi_ad,kisi_tel)

    fun sil(kisi_id: String) = kds.sil(kisi_id)

    fun kisiYukle() : List<Kisiler> = kds.kisiYukle()

    fun ara(aramaKelimesi:String) : List<Kisiler> = kds.ara(aramaKelimesi)
}