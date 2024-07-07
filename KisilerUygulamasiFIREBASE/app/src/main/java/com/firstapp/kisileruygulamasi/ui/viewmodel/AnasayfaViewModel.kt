package com.firstapp.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var krepo:KisilerRepository) : ViewModel() {
    //var krepo = KisilerRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init{
        //Uygulama ilk açıldığında kisilerlistesini görmek istediğimiz için init içinde uygulama başlarken çalıştırıyoruz.
        kisiYukle()
    }

    fun sil(kisi_id:String)
    {
        krepo.sil(kisi_id)
    }

    fun kisiYukle() {
        kisilerListesi.value = krepo.kisiYukle()
    }

    fun ara(aramaKelimesi:String) {
        kisilerListesi.value = krepo.ara(aramaKelimesi)
    }
}