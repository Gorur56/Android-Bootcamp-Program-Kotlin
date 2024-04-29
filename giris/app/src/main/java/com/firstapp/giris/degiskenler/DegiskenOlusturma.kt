package com.firstapp.giris.degiskenler

fun main() {
    var ogrAd = "Ahmet"
    var ogrYas = 15
    var ogrBoy = 1.85
    var ogrBasharf = 'A'
    var ogrDevamEdiyormu = true

    println(ogrAd)
    println(ogrYas)
    println(ogrBoy)
    println(ogrBasharf)
    println(ogrDevamEdiyormu)


    //Açıklamalı ve Tür belirterek

    var urun_id : Int = 3356
    var urun_adi : String = "Macbook Pro"
    var urun_adet : Int = 100
    var urun_fiyat : Double = 42999.99
    var urun_tedarikci : String = "Apple"

    println();
    println("Ürün id: $urun_id")
    println("Ürün Adı: $urun_adi")
    println("Ürün Adeti: $urun_adet")
    println("Ürün Fiyat: $urun_fiyat $")
    println("ürün Tedarik: $urun_tedarikci")


    var a = 10
    var b = 20

    println("$a x $b : ${a*b}")

    //SABİTLER - CONSTANT

    // Eğer sabit bir değişken tanımlayacaksak;
    // val(kotlin) - let(swift) - C++(const) - Java( final) gibi...

    println();
    var sayi = 10
    println(sayi)
    sayi = 20
    println(sayi)

    val num = 40
    println(num)
    //num = 100 // Val cannot be reassigned hatası verir.


    //TÜR DÖNÜŞÜMÜ - Type Casting

    val i = 52

    val d = 78.96

    //Sayısaldan Sayısala Dönüşüm

    val sonuc1 = i.toDouble()
    val sonuc2 = d.toInt() //Veri kaybına uğrar.

    println("sonuç1: $sonuc1")
    println("sonuç2: $sonuc2")


    //Sayısaldan Metine Dönüşüm

    val sonuc3 = i.toString()
    val sonuc4 = d.toString()

    println("Sonuç3: $sonuc3")
    println("Sonuç4: $sonuc4")

    //Metinden Sayısaya Dönüşüm
    val str = "89"
    val sonuc5 = str.toInt()
    val sonuc6 = str.toDouble()

    println("Sonuç5: $sonuc5")
    println("Sonuç6: $sonuc6")

    val strDouble = "89.56t" //Böyle bir değeri dönüştürmek istersek hata fırlatır ve uygulama çöker.
    val sonuc7 = strDouble.toDoubleOrNull(); //null döndürür. Uygulama çökmez.
    println("sonuç7: $sonuc7")

    //Veya null değer böyle çözülebilir

    if( sonuc7 != null)
    {
        println(sonuc7)
    }
    else
    {
        println("Dönüşüm hatası oluştu. SAyınızı kontrol ediniz.")
    }

    sonuc7.let {
        //Yukarıdaki if ile aynı işi yapar. Ama burada else yazılmıyor.
        println(it) //Silik it sonuc7 'yi ifade eder.
    }

}