package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    ucretHesapla(145,KonserveBoyutu.KUCUK)
    ucretHesapla(120,KonserveBoyutu.ORTA)
    ucretHesapla(90,KonserveBoyutu.BUYUK)
}

fun ucretHesapla(adet:Int, boyut: KonserveBoyutu)
{
    when(boyut){
        KonserveBoyutu.KUCUK-> println("Toplam Maliyet: ${adet*30}$")
        KonserveBoyutu.ORTA-> println("Toplam Maliyet: ${adet*40}$")
        KonserveBoyutu.BUYUK-> println("Toplam Maliyet: ${adet*50}$")
    }
}