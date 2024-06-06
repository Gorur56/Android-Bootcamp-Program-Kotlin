package com.example.mvvmkullanimi

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    //Class'ta yapılacak işlemler View Model 'e yptırılır.
    var sonuc = "0"
    fun toplamaYap(alinanSayi1:String, alinanSayi2: String){
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val toplam = sayi1 + sayi2
        sonuc = toplam.toString()
    }

    fun carpmaYap(alinanSayi1:String, alinanSayi2: String){

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpma = sayi1 * sayi2
        sonuc = carpma.toString()
    }
}