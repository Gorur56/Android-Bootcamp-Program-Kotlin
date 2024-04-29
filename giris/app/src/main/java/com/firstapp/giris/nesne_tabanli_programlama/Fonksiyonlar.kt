package com.firstapp.giris.nesne_tabanli_programlama

class Fonksiyonlar {
    //void - Geri dönüş değeri olmayan

    fun selamla1(){
        val sonuc = "Merhaba Ahmet"
        println(sonuc)
    }

    //rerturn - geri dönüş değeri döndüren fonksiyonlar

    fun selamla2() : String{
        val sonuc = "Merhaba Mehmet"
        return sonuc
    }

    //Değer Alan Fonksiyonlar

    fun selamla3(isim:String){
        val sonuc = "Merhaba $isim"
        println(sonuc)
    }

    fun toplama(sayi1:Int, sayi2:Int) : Int{
        val sonuc = sayi1 + sayi2
        return sonuc
    }

    //OverLoading -> İsimleri aynı imzaları farklı olan fonksiyonlardır.
    //farklı parametrelerle aynı işi yapan fonksiyonları farklı isimlerile oluşturmamızı engeller.
    fun carp(sayi1:Int, sayi2:Int)
    {
        println("Çarpma: ${sayi1*sayi2}")
    }

    fun carp(sayi1:Double, sayi2:Int)
    {
        println("Çarpma1: ${sayi1*sayi2}")
    }

    fun carp(sayi1:Double, sayi2:Double)
    {
        println("Çarpma2: ${sayi1*sayi2}")
    }

    fun carp(sayi1:Int,sayi2:Int, isim:String)
    {
        println("Çarpma3 : ${sayi1*sayi2} - İşlem yapan ${isim}")
    }
}