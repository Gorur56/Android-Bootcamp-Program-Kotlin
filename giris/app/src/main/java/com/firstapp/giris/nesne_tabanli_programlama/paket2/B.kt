package com.firstapp.giris.nesne_tabanli_programlama.paket2

import com.firstapp.giris.nesne_tabanli_programlama.paket1.A //FArklı paketten çağırdığımız için import ediyoruz

class B : A(){ // : A() ile miras alıyoruz.
    fun fonksiyon(){
        val nesne = A()

        //Kalıtım aldığımız için artık ağaıdaki gibi nesne oluşturup çağırmamıza gerek yok. Nesnelere direk erişebiliriz.
        /*println(nesne.varsayilanDegisken)
        println(nesne.publicDegisken)
        println(nesne.internalDegisken)*/

        println(varsayilanDegisken)
        println(publicDegisken)
        println(internalDegisken)
        println(protectedDegisken)
        func() //private için
    }
}