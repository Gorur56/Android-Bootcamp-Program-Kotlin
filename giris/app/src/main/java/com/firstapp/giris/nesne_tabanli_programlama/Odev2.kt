package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    //ODEV1 = Parametre olarak girilen kilometreyi mile dönüştürdükten sonra geri
    //döndüren bir metod yazınız. Mile = Km x 0.621

    val mile = mile(56.0)
    println("Gelen Mile: $mile")

    //ODEV2: Kenarları parametre olarak girilen ve dikdörtgenin alanını hesaplayan bir metod yazınız.

    dikdortgenAlan(12,8)

    //ODEV3: Parametre olarak girilen sayının faktoriyel değerini hesaplayıp geri döndüren metodu yazınız.
    val sonuc = faktoriyel(5)
    println("Faktoriyel Sonuç: $sonuc")

    //ODEV4: Parametre olarak girilen kelime içinde kaç adet e harfi olduğunu gösteren bir metod yazınız.

    val kelime = "Şekerleme"

    val sum = eHarfiSayisi(kelime)
    println("$kelime 'nin içinde $sum tane e harfi vardır.")
}

fun mile(km:Double) : Double{
    val mile = km * 0.621
    return mile
}

fun dikdortgenAlan(uzun:Int,kisa:Int)
{
    val sonuc = uzun * kisa
    println("dikdörtgenin Alanı: $sonuc")
}

fun faktoriyel(num:Int) : Int {
    if( num <= 1 )
    {
        return 1
    }
    else
    {
        return num * faktoriyel(num -1)
    }
}

fun eHarfiSayisi(kelime:String) : Int{
    var eSayisi = 0

    for (harf in kelime)
    {
        if (harf == 'e')
        {
            eSayisi++
        }
    }
    return eSayisi
}