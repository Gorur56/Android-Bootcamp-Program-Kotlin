package com.firstapp.giris.nesne_tabanli_programlama.composition

fun main() {
    val k1 = Kategoriler(1,"Dram")
    val k2 = Kategoriler(2,"Komedi")

    val y1 = Yonetmenler(1, "Quentin Tarantino")
    val y2 = Yonetmenler(2, "Yılmaz Erdoğan")

    val f1 = Filmler(1, "Django",2013, k1,y1)
    val f2 = Filmler(2,"Ekşi Elmalar", 2014,k2,y2)

    println("Film id: ${f1.film_id}")
    println("Film ad: ${f1.film_ad}")
    println("Film yıl: ${f1.film_yil}")
    println("Film kategori: ${f1.kategori.kategori_ad}")
    println("Film yönetmen: ${f1.yonetmen.yonetmen_ad}")

    println()
    println("Film id: ${f2.film_id}")
    println("Film ad: ${f2.film_ad}")
    println("Film yıl: ${f2.film_yil}")
    println("Film kategori: ${f2.kategori.kategori_ad}")
    println("Film yönetmen: ${f2.yonetmen.yonetmen_ad}")
}