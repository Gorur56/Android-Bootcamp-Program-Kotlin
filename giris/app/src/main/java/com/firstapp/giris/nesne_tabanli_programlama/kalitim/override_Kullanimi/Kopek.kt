package com.firstapp.giris.nesne_tabanli_programlama.kalitim.override_Kullanimi

class Kopek : Memeli() {
    //Memeli sınfı Hayvan sınıfından miraz aldığı için önce memeli sınıfına sonra Hayvan sınıfından bu özelliği alabildik.
    override fun sesCikar() {
        println("Hav Hav")
    }
}