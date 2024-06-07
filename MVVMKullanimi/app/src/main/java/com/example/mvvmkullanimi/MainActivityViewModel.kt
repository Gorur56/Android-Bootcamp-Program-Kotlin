package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    //Class'ta yapılacak işlemler View Model 'e yptırılır.
    //var sonuc = "0"

    //LiveData
    var sonuc = MutableLiveData("0")
    var mrepo =MatematikRepository()
    fun toplamaYap(alinanSayi1:String, alinanSayi2: String){
       /*Bu işlemi artık DataSource yapıyor.
       val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2
        sonuc.value = toplam.toString()*/
        //Dispatchers.Main => arayüz işlemlerinde kullanılır.
        CoroutineScope(Dispatchers.Main).launch {
            //LiveData 'ya sonuç ekleyeceğiz
            sonuc.value = mrepo.toplamaYap(alinanSayi1,alinanSayi2)
        }
    }

    fun carpmaYap(alinanSayi1:String, alinanSayi2: String){

        /*Bu işlemi artık DataSource yapıyor.
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpma = sayi1 * sayi2
        sonuc.value = carpma.toString()*/
        CoroutineScope(Dispatchers).launch {
            sonuc.value = mrepo.carpmaYap(alinanSayi1,alinanSayi2)
        }
    }
}