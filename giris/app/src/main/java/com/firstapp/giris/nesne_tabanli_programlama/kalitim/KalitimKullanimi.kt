package com.firstapp.giris.nesne_tabanli_programlama.kalitim

import com.firstapp.giris.nesne_tabanli_programlama.kalitim.Saray
import com.firstapp.giris.nesne_tabanli_programlama.kalitim.Villa

fun main() {
    val topkapiSarayi = Saray(5, 25)
    val bogazVilla = Villa(true,30)

    println(topkapiSarayi.kuleSayisi)
    println(topkapiSarayi.pencereSayisi)

    println()
    println(bogazVilla.garajVarmi)
    println(bogazVilla.pencereSayisi)

    println("")
    //is ile if koşulu sağlanabilir. Özellikle nesne ve sınıfı karşılaştırırken

    if(topkapiSarayi is Saray)
    {
        println("Saraydır.")
    }
    else
    {
        println("Saray değildir.")
    }

    //Up ve Down Castting işlemini yapabilmek için KALITIM olması gerekiyor.
    //UPCASTING: Alt sınıfı üst sınıfa
    //Saray ve Villa sınıfını Ev sınfına dönüştüreceğiz.

    val ev:Ev = bogazVilla
    val evv:Ev = topkapiSarayi

    //DownCasting: Üst sınıfı Alt sınıfa dönüştürüyoruz.
    val ev1 = Ev(7)
    val saray = ev1 as Saray
}