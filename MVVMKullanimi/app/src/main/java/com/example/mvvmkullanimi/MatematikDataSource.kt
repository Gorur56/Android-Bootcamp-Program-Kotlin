package com.example.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    //Corourtine ile Asenkron bir çalışma ile veri gönderiyoruz.
    // Coroutineler, suspend anahtar kelimesi ile tanımlanır ve launch, async, await gibi yapı taşları ile kullanılır.
    suspend fun toplamaYap(alinanSayi1:String, alinanSayi2: String) : String =
        withContext(Dispatchers.IO){
            //Coroutine ile veri gönderme
            //return edeceksek withContenxt kullanılır.
            //Dispatchers.IO: Veri tabanı ile işlem yapılacaksa kullanılır.
            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()
            val toplam = sayi1 + sayi2

            return@withContext toplam.toString()
        }


    suspend fun carpmaYap(alinanSayi1:String, alinanSayi2: String) : String =
        withContext(Dispatchers.IO){
            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()
            val carpma = sayi1 * sayi2

            return@withContext carpma.toString()
        }
}