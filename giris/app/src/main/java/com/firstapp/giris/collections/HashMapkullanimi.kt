package com.firstapp.giris.collections

fun main() {
    //Dictionary olarakda geçer.
    //Arraylist 'in daha geliştirilmiş halidir.
    //Key ve value yapısı vardır.
    //Key 'ler unique olur. Key üzerinden işlemler yapabiliyoruz.
    val iller = HashMap<Int,String>()

    iller.put(16,"Bursa")
    iller.put(34,"İstanbul")
    iller.put(1,"Adana")

    //Veya bu şekilde ekleyebiliriz.
    iller[6] = "Ankara"

    println(iller)

    //Veri Okuma
    println(iller[16])


    //Veri Güncelleme
    iller.put(16,"Yeni Bursa")
    println(iller)

    println(iller.size)
    println(iller.isEmpty())

    for ((anahtar,iller) in iller)
    {
        println("Plaka: $anahtar İl: $iller")
    }


    //Veri Silme
    println("")
    iller.remove(1)
    println(iller)

    //Tüm veriyi temizleme
    iller.clear()

}