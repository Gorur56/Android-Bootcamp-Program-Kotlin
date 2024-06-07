package com.firstapp.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitViewModel : ViewModel() {
    var krepo = KisilerRepository()
    fun kaydet(kisi_ad:String, kisi_tel:String){
        //Eğer suspend hatası almak istemiyorsak en son asenkron kullanacğaımız fonksiyonda Coroutine kullanmamız gerekiyor.
        //Burada da suspen yapsakdık burayı çağıran yerde suspend hatası verir.
        CoroutineScope(Dispatchers.Main).launch{
            krepo.kaydet(kisi_ad,kisi_tel)
        }
    }
}