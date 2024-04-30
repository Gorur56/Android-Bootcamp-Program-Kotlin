package com.firstapp.giris.nesne_tabanli_programlama.paket2

import com.firstapp.giris.nesne_tabanli_programlama.paket1.A //FArklı paketten çağırdığımız için import ediyoruz

class B {
    fun fonksiyon(){
        val nesne = A()

        println(nesne.varsayilanDegisken)
        println(nesne.publicDegisken)
        println(nesne.internalDegisken)
    }
}