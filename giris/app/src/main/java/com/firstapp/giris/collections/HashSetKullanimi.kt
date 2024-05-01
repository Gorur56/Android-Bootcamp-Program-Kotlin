package com.firstapp.giris.collections

import java.util.HashSet

fun main() {
    //HashSet 'e diziyi benzer. Ama burada index yoktur.
    //Değerler unique olmak zorundadır. Aynı değer tekrarlanmaz. Örneğin tekrar eden değerleri bulmak için bu özellik kullanılabilir.
    //Değer eklenince sıralı değil. Herhangi bir yere ekler. Örneğin bir müzik listesi oluşturunca kullanılabilir.


    val meyveler = HashSet<String>()

    meyveler.add("Armut")
    meyveler.add("Çilek")
    meyveler.add("Kiraz")
    meyveler.add("Muz")
    meyveler.add("Erik")
    meyveler.add("Portakal")
    meyveler.add("Ananas")
    meyveler.add("İncir")
    meyveler.add("Kayısı")

    println(meyveler)

    //Aynı veriyi tekrar eklemek istersek aynı veriden bir tane getirir.
    meyveler.add("Armut")
    println(meyveler)

    //index olmadığı için böyle bir özellik geliştirilip sayısı ile getirtebiliyoruz
    println(meyveler.elementAt(1)) //O an 1 'e hangi değer atandıysa onu getirir
    println(meyveler.size)
    println(meyveler.count())
    println(meyveler.isEmpty())

    //iter ile verileri tek tek alabiliriz
    println("")
    for (meyve in meyveler)
    {
        println("Sonuç: $meyve")
    }

    //Index ile
    println("")
    for ((index,meyve) in meyveler.withIndex())
    {
        //İndex sırası sıralı gelir ama her serinde değerlerin yeri değişir.
        println("$index. -> $meyve")
    }

    //HashSet Veri Silme
    meyveler.remove("Çilek")
    println(meyveler)

    meyveler.clear() //ile hepsini silebiliriz.
    println(meyveler)
}