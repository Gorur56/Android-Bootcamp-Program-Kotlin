package com.firstapp.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel : ViewModel() {
    var krepo = KisilerRepository()
    fun kaydet(kisi_id:Int, kisi_ad:String, kisi_tel:String)
    {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.guncelle(kisi_id, kisi_ad,kisi_tel)
        }
    }
}