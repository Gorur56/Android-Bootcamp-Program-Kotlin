package com.firstapp.giris.standart_programlama

fun main(){
    val yas = 19
    val isim = "Mehmet"

    if( yas >= 18) // swift : if yas >= 18 { }
    {
        println("Reşitsiniz.")
    }
    else
    {
        println("Reşit değilsiniz.")
    }

    if ( isim == "Ahmet")
    {
        println("Merhaba Ahmet")
    }
    else if( isim == "Mehmet")
    {
        println("Merhaba Mehmet")
    }
    else
    {
        println("Tanınmayan Kişi")
    }


    val ka = "admin"
    val sifre = 123456

    if( ka === "admin" && sifre == 123456 )
    {
        println("Hoşgeldiniz.")
    }
    else
    {
        println("Hatalı giriş!!!")
    }

    val gun = 4

    //WHEN diğer dillerdeki switch case 'dir.
    when(gun){
        1-> println("Pazartesi")
        2-> println("Salı")
        3-> println("Çarşamba")
        4-> println("Perşembe")
        5-> println("Cuma")
        6-> println("Cumartesi")
        7-> println("Pazar")
        else-> println("Böyle bir gün yok")
    }
}