package com.firstapp.giris.collections

fun main() {
    //Dizi 'nin gelişmiş halidir. Dizi gbi index mantığı ile çalışıyor. Ama boyut dinamiktir.
    val sayilar = ArrayList<Int>()
    val meyveler = ArrayList<String>()

    //Veri Ekleme
    meyveler.add("Elma")
    meyveler.add("Portakal")
    meyveler.add("Muz")

    println(meyveler)

    //Veri Güncelleme
    meyveler[1] = "Karpuz"
    println(meyveler)

    //Insert yöntemi ile istediğimiz indeks 'e yapabiliriz. Eklediğimiz indeksteki değer bir yana kayar.
    meyveler.add(1,"Kavun")
    println(meyveler)

    //Veri Okuma
    println(meyveler[2])
    println(meyveler.get(1))

    //Boyut
    println("Boyut: ${meyveler.size}")
    println("Boyut: ${meyveler.count()}")

    //Boş dolu kontrol
    println("İçeriği boş mu?: ${meyveler.isEmpty()}")
    println("İçeriyor mu? ${meyveler.contains("Kavun")}")

    //içeriğini terse çevirme
    meyveler.reverse()
    println(meyveler)

    //Harf sırasına göre sıralama
    meyveler.sort()
    println(meyveler)

    //Listeyi tek tek ele alabiliriz.
    for(meyve in meyveler) //ite
    {
        //Sırayla tek tek yazdırır.
        println("Sonuç: $meyve")
    }
    println()

    //indeks numarasına ihtiyacımız olurda
    for((indeks,meyve) in meyveler.withIndex()) //swift ile enumareted()
    {
        val yeniIndeks = indeks + 1
        println("$yeniIndeks. -> $meyve ")
    }

    //Veri Silme
    meyveler.removeAt(2)
    println(meyveler)

    //Hepsini silmek istersek
    meyveler.clear()
    println(meyveler)
}