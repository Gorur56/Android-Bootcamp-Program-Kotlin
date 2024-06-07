package com.firstapp.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    var krepo = KisilerRepository()

    fun sil(kisi_id:Int)
    {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)
        }
    }
}