package com.firstapp.giris.nesne_tabanli_programlama.interface_kullanimi

fun main() {
    val interface1 = ClassA()

    println(interface1.degisken)
    interface1.method1()
    println(interface1.method2())

    println("")
    val interface2 = ClassA()
    println(interface2.degisken2)
    interface2.method3()
    println(interface2.method4())

}