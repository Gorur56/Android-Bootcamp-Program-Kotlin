package com.firstapp.giris.collections

import kotlin.math.log

fun main() {
    val o1 = OgrencilerArrayList(100,"Merve","9c")
    val o2 = OgrencilerArrayList(300, "Ahmet","10b")
    val o3 = OgrencilerArrayList(200,"Mehmet","11a")

    val ogrencilerArrayList = ArrayList<OgrencilerArrayList>()

    ogrencilerArrayList.add(o1)
    ogrencilerArrayList.add(o2)
    ogrencilerArrayList.add(o3)

    for (ogr in ogrencilerArrayList)
    {
        println("Ogrenci no: ${ogr.ogrNo} ad: ${ogr.ogrAd} sınıf: ${ogr.ogrSinif}")
    }

    //Sort - Sınıf Nesnelerini Sıralama
    println("")
    println("Sayısal : Küçükten > Büyüğe: ")
    val siralama1 = ogrencilerArrayList.sortedWith(compareBy{it.ogrNo}) //ASC (asend): Bu ifade küçükten büyüğe doğru sıralar.
    for (ogr in siralama1)
    {
        println("No: ${ogr.ogrNo} : Ad: ${ogr.ogrAd} : Sınıf: ${ogr.ogrSinif}")
    }

    println("")
    println("Sayısal : Büyükten > küçüğe: ")
    val siralama2 = ogrencilerArrayList.sortedWith(compareByDescending { it.ogrNo }) //DESC(descend): Bu ifade büyükten küçüğe doğru sıralar
    for (ogr in siralama2)
    {
        println("No: ${ogr.ogrNo} : Ad: ${ogr.ogrAd} : Sınıf: ${ogr.ogrSinif}")
    }


    println("")
    println("Metinsel: İsme Göre Sıralama ASC")
    val siralama3 = ogrencilerArrayList.sortedWith(compareBy{it.ogrAd})
    for(ogr in siralama3)
    {
        println("No: ${ogr.ogrNo} : Ad: ${ogr.ogrAd} : Sınıf: ${ogr.ogrSinif}")
    }

    println("")
    println("Metinsel: İsme Göre Sıralama DESC")
    val siralama4 = ogrencilerArrayList.sortedWith(compareByDescending { it.ogrAd })

    for (ogr in siralama4)
    {
        println("No: ${ogr.ogrNo} : Ad: ${ogr.ogrAd} : Sınıf: ${ogr.ogrSinif}")
    }


    //Filtreleme1 : Büyük küçük koşulu
    println("")
    println("Filtreleme 1")
    val filtreleme1 = ogrencilerArrayList.filter { it.ogrNo >= 200 } //Öğrenci numarası 200 'e eşit ve büyük kayıtları getirecek.

    for( ogr in filtreleme1 )
    {
        println("No: ${ogr.ogrNo} : Ad: ${ogr.ogrAd} : Sınıf: ${ogr.ogrSinif}")
    }

    //Filtreleme2 : içinde istediğimiz değeri bulan kayıtları getirme
    println("")
    println("Filtreleme 2")
    val filtreleme2 = ogrencilerArrayList.filter{it.ogrAd.contains("M")} //Adında M harfi olan kayıtları getirir.

    for(ogr in filtreleme2)
    {
        println("No: ${ogr.ogrNo} : Ad: ${ogr.ogrAd} : Sınıf: ${ogr.ogrSinif}")

    }
}