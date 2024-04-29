package com.firstapp.giris.nesne_tabanli_programlama

class Araba(var renk:String, var hiz:Int, var calisiyormu:Boolean){

    //Tekrar eden olaylar için fonksiyon oluşturma

    fun calistir(){ //Side effect Fonksiyon ile sınıfın özelliklerini değiştirebilme
        calisiyormu = true
        hiz = 5
    }

    fun durdur()
    {
        calisiyormu = false
        hiz = 0
    }

    fun bilgiAl()
    {
        println("----------------------------------------------")
        println("Renk          : ${this.renk}")
        println("Hız           : ${this.hiz}")
        println("Çalışıyor mu  : ${this.calisiyormu}")
    }

    //this veya self(swift) : Bulunduğunuz sınıfı
    //super: kalıtım varsa üst sınıfı temsil eder.
}