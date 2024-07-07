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
        //addSnapshotListener: Gerçek zamanlı veri okumamızı sağlar.
        collectionKisiler.addSnapshotListener { value, error ->
            if(value != null)
            {
                val liste = ArrayList<Kisiler>()
                for(d in value.documents) //documents gelen veri sayısı kadar çalış
                {
                    //Gelen d 'yi yani kisiid,ad, ve tel verisi kisi nesnesine çeviriyoruz.
                    val kisi = d.toObject(Kisiler::class.java)

                    if(kisi != null)
                    {
                        kisi.kisi_id = d.id
                        liste.add(kisi) //Gelen nesneyi listeye ata
                    }
                }

                kisilerListesi.value = liste //Listeyi arayüze gönder
            }
        }
        return kisilerListesi
    }

    fun ara(aramaKelimesi:String) : MutableLiveData<List<Kisiler>> {
        collectionKisiler.addSnapshotListener{ value, error->
            if(value != null){
                val liste = ArrayList<Kisiler>()

                for (d in value.documents)
                {
                    val kisi = d.toObject(Kisiler::class.java)

                    if (kisi != null)
                    {
                        //Arama işlemi için if koşulu
                        if(kisi.kisi_ad!!.lowercase().contains(aramaKelimesi.lowercase())){
                            kisi.kisi_id = d.id
                            liste.add(kisi)
                        }
                    }
                }
                kisilerListesi.value = liste
            }
        }
        return kisilerListesi
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
        //Any: Gelen değerin türleri farklı olabilir.
        val guncellenenKisi = HashMap<String,Any>()
        guncellenenKisi["kisi_ad"]  = kisi_ad
        guncellenenKisi["kisi_tel"] = kisi_tel
        collectionKisiler.document(kisi_id).update(guncellenenKisi)



    }

    fun sil(kisi_id: String)
    {
        Log.e("Kişi Sil", "$kisi_id")
        collectionKisiler.document(kisi_id).delete()
    }
}