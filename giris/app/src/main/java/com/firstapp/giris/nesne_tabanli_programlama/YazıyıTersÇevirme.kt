package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    println("Bir yazı giriniz: ")
    val girilenDeger = readLine()

    val tersCevir = girilenDeger?.reversed()

    println("Ters: $tersCevir")
}