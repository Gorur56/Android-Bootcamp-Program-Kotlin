package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    //Çağırdığımız nesne ve fonksiyon artık statik olduğu için bu şekilde çağıramayız.
    /*
    var nesne = ASinifi() //Nesne oluşturur

    println(nesne.x)
    nesne.metod()

    println()

    //Virtual Object - Sanal Nesne - isimsiz Nesne

    println(ASinifi().x) //Her biri hafızada ayrı nesne oluşturur.
    ASinifi().metod() //Nesne oluşturur */

    //Statik nesneye aşağıdaki gibi erişilir.

    println(ASinifi.x)
    ASinifi.metod()
}