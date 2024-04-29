package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    //Extension: Var olan fonksiyonları genişletmek
    val sonuc = 5.carp(2)
    println("Gelen Sonuç: $sonuc")

    //Infix sayesinde bu şekilde yazabiliriz
    val sum = 6 topla 8
    println("Gelen Toplam: $sum")

}

fun Int.carp(sayi:Int): Int{
    //Fonksiyonumuz artık Int sınıfının fonksiyonu oldu. kendimiz fonksiyon ekledik
    return this * sayi //this == Int sınıfı
}

infix fun Int.topla(sayi:Int): Int{
    //Fonksiyonumuz artık Int sınıfının fonksiyonu oldu. kendimiz fonksiyon ekledik
    return this + sayi //this == Int sınıfı
}