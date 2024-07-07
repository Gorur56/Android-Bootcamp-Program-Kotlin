package com.firstapp.kisileruygulamasi.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource( var collectionKisiler: CollectionReference) {
    //kisi yükleme ve arama işlemini artık coruatines 'lerle değil. LiveData ile yapıyoruz.
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun kisiYukle() : MutableLiveData<List<Kisiler>> {
        return MutableLiveData<List<Kisiler>>()
    }

    fun ara(aramaKelimesi:String) : MutableLiveData<List<Kisiler>> {
        return MutableLiveData<List<Kisiler>>()
    }

    fun kaydet(kisi_ad:String, kisi_tel:String)
    {
        //Firebase 'de id oluştuğu için burada id yi boş bırakıyoruz.
        val yeniKisi = Kisiler("",kisi_ad,kisi_tel)
        collectionKisiler.document().set(yeniKisi)
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