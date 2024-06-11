package com.firstapp.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class AnasayfaViewModel : ViewModel() {
    var krepo = KisilerRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init{
        //Uygulama ilk açıldığında kisilerlistesini görmek istediğimiz için init içinde uygulama başlarken çalıştırıyoruz.
        kisiYukle()
    }

    fun sil(kisi_id:Int)
    {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)
            kisiYukle() //Silme işleminden sonra listeyi güncelle
        }
    }

    fun kisiYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.kisiYukle()
        }
    }

    fun ara(aramaKelimesi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.ara(aramaKelimesi)
        }
    }
}