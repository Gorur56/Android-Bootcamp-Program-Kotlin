package com.firstapp.giris.nesne_tabanli_programlama.kalitim.override_Kullanimi

fun main() {
    val hayvan = Hayvan()
    val memeli = Memeli()
    val kedi = Kedi()
    val kopek = Kopek()

    hayvan.sesCikar() //Kalıtım yok, Kendi sınıfına erişti.
    memeli.sesCikar() //Kalıtım var. Kendi özelliği olmadığı için kalıtım aldığı üst sınıfın özelliğini aldı.
    kedi.sesCikar()
    kopek.sesCikar()


    //NOT: Eğer Memelide özellik olsaydı. Kedi veya köpekte özellik olmasaydı. Memeli sınıfının özeliğini kullanacakalrdı.
}