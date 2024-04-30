package com.firstapp.giris.nesne_tabanli_programlama.composition

import com.firstapp.giris.nesne_tabanli_programlama.kalitim.Saray
import com.firstapp.giris.nesne_tabanli_programlama.kalitim.Villa

fun main() {
    val topkapiSarayi = Saray(5, 25)
    val bogazVilla = Villa(true,30)

    println(topkapiSarayi.kuleSayisi)
    println(topkapiSarayi.pencereSayisi)

    println()
    println(bogazVilla.garajVarmi)
    println(bogazVilla.pencereSayisi)
}