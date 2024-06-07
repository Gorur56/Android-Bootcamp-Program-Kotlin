package com.example.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    //Asenkron bir çalışma ile veri gönderiyoruz.
    suspend fun toplamaYap(alinanSayi1:String, alinanSayi2: String) : String =
        withContext(Dispatchers.IO){
            //Coroutine ile veri gönderme
            //return edeceksek withContenxt kullanılır.
            //Dispatchers.IO: Veri tabanı ile işlem yapılacaksa kullanılır.
            val sayi1 = alinanSayi1.toString()
            val sayi2 = alinanSayi2.toString()
            val toplam = sayi1 + sayi2

            return@withContext toplam.toString()
        }


    suspend fun carpmaYap(alinanSayi1:String, alinanSayi2: String) : String =
        withContext(Dispatchers.IO){
            val sayi1 = alinanSayi1.toString()
            val sayi2 = alinanSayi2.toString()
            val carpma = sayi1 * sayi2

            return@withContext carpma.toString()
        }
}