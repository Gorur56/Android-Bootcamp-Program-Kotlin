package com.firstapp.giris.nesne_tabanli_programlama

data class Araba(var renk:String, var hiz:Int, var calisiyormu:Boolean){ //Constructer Nesne oluştuğu anda ilk çalışan methoddur.

    //Burada java veya diğer dillerdeki gibi kapsülleme ile get set oluşturmuyoruz.
    //data keyword 'ü sınıfın başına yazınca bizim için arka planda oluşturuyor.

    private var str = "Merhaba"
    //bir class 'tan nesne oluşturduğumuz zaman çalışan fonksiyon init
    //Her nesne oluşturulduğunda çalışıyor.
    init {
        println("Constructor Çalıştı...")
    }

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

    fun hizlan(kacKm:Int)
    {
        hiz = hiz + kacKm
    }

    fun yavasla(kacKm:Int)
    {
        hiz -= kacKm
    }

    //this veya self(swift) : Bulunduğunuz sınıfı
    //super: kalıtım varsa üst sınıfı temsil eder.
}