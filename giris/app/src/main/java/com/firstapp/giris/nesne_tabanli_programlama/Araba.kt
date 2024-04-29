package com.firstapp.giris.nesne_tabanli_programlama

class Araba(var renk:String, var hiz:Int, var calisiyormu:Boolean){

    //Tekrar eden olaylar için fonksiyon oluşturma

    fun bilgiAl()
    {
        println("----------------------------------------------")
        println("Renk          : ${renk}")
        println("Hız           : ${hiz}")
        println("Çalışıyor mu  : ${calisiyormu}")
    }

}