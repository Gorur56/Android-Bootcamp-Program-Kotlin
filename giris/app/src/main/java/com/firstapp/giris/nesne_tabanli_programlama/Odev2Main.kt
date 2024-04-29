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


    //ODEV5 Parametre olarak girilen kenar sayısına göre her bir iç açıyı hesaplayıp sonucu geri gönderen metod
    //yazınız. İç açılar toplamı = ( (Kenar sayısı - 2) x 180 ) / Kenar sayısı

    val sumEdge = odev.sumEdge(12)
    println("İç açılarının Toplamı: $sumEdge")

    // ODEV6: Parametre olarak girilen gün sayısına göre maaş hesabı yapan ve elde edilen değeri döndüren metod yazınız.
    //• 1 günde 8 saat çalışılabilir.
    //• Çalışma saat ücreti : 40 ₺
    //• Mesai saat ücreti : 80 ₺
    //• 150 saat üzeri mesai sayılır.

    val topMaas = odev.maasHesapla(20)
    println("Toplam maaş: $topMaas")


    //ODEV7: Parametre olarak girilen otopark süresine göre otopark ücreti hesaplayarak geri döndüren metodu yazınız.
    //• 1 saat = 50 ₺
    //• 1 saat aşımından sonra her 1 saat , 10 ₺’dir.
    val ucret = odev.otoparkUcreti(5)
    println("Otopark Ücreti : ${ucret}")
}