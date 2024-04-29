package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    val odev = Odev2()
    //ODEV1 = Parametre olarak girilen kilometreyi mile dönüştürdükten sonra geri
    //döndüren bir metod yazınız. Mile = Km x 0.621

    val mile = odev.mile(56.0)
    println("Gelen Mile: $mile")

    //ODEV2: Kenarları parametre olarak girilen ve dikdörtgenin alanını hesaplayan bir metod yazınız.

    odev.dikdortgenAlan(12,8)

    //ODEV3: Parametre olarak girilen sayının faktoriyel değerini hesaplayıp geri döndüren metodu yazınız.
    val sonuc = odev.faktoriyel(5)
    println("Faktoriyel Sonuç: $sonuc")

    //ODEV4: Parametre olarak girilen kelime içinde kaç adet e harfi olduğunu gösteren bir metod yazınız.

    val kelime = "Şekerleme"

    val sum = odev.eHarfiSayisi(kelime)
    println("$kelime 'nin içinde $sum tane e harfi vardır.")
}