package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    //Nesne Oluşturma
    val bmw = Araba("Kırmızı",0,true)

    //Okuma
    /*println("Renk          : ${bmw.renk}")
    println("Hız           : ${bmw.hiz}")
    println("Çalışıyor mu  : ${bmw.calisiyormu}")*/

    bmw.bilgiAl()

    //Veri Atama

    bmw.renk = "Mavi"
    bmw.hiz = 180
    bmw.calisiyormu = false
    println("----------------------------------------------")

    //Okuma
    bmw.bilgiAl()
    bmw.calistir()
    bmw.bilgiAl()

    println("---------------------------------------------")
    val sahin = Araba("Beyaz",100,true)

    //okuma
    sahin.bilgiAl()
    sahin.durdur()
    sahin.bilgiAl()


    sahin.hizlan(50)
    sahin.bilgiAl()

    sahin.yavasla(5)
    sahin.bilgiAl()
}