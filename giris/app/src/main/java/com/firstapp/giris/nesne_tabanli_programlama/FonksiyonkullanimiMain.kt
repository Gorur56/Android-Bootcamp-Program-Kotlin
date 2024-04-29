package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    val func = Fonksiyonlar()

    func.selamla1()

    val gelenSonuc = func.selamla2()
    println(gelenSonuc)

    func.selamla3("Sevim")

    val gelenToplam = func.toplama(25,69)
    println("Toplama Sonuç: ${gelenToplam}")

    println("")

    func.carp(5,8)
    func.carp(9.5,25)
    func.carp(10.0,30.0)
    func.carp(6,8,"Ayşe")
}