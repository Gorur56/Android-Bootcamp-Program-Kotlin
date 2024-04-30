package com.firstapp.giris.nesne_tabanli_programlama.kalitim.override_Kullanimi

open class Hayvan {
    open fun sesCikar(){ //open keyword koymassak override yapamayız.
        println("Sesim yok.")
    }
}