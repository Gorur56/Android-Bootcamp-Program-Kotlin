package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    //Nesne Oluşturma
    val bmw = Araba("Kırmızı",0,true)

    //Okuma
    println("Renk          : ${bmw.renk}")
    println("Hız           : ${bmw.hiz}")
    println("Çalışıyor mu  : ${bmw.calisiyormu}")

    //Veri Atama

    bmw.renk = "Mavi"
    bmw.hiz = 180
    bmw.calisiyormu = false
    println("----------------------------------------------")

    //Okuma
    println("Renk          : ${bmw.renk}")
    println("Hız           : ${bmw.hiz}")
    println("Çalışıyor mu  : ${bmw.calisiyormu}")

    println("---------------------------------------------")
    val sahin = Araba("Beyaz",100,false)

    println("Renk         : ${sahin.renk}")
    println("Hız          : ${sahin.hiz}")
    println("Çalışıyor mu : ${sahin.calisiyormu}")
}