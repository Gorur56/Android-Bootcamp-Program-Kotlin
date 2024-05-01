package com.firstapp.giris.collections

import kotlin.math.log

fun main() {
    val o1 = OgrencilerArrayList(1,"Merve","9c")
    val o2 = OgrencilerArrayList(2, "Ahmet","10b")
    val o3 = OgrencilerArrayList(3,"Mehmet","11a")

    val ogrencilerArrayList = ArrayList<OgrencilerArrayList>()

    ogrencilerArrayList.add(o1)
    ogrencilerArrayList.add(o2)
    ogrencilerArrayList.add(o3)

    for (ogr in ogrencilerArrayList)
    {
        println("Ogrenci no: ${ogr.ogrNo} ad: ${ogr.ogrAd} sınıf: ${ogr.ogrSinif}")
    }
}