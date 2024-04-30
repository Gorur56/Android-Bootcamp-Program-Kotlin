package com.firstapp.giris.nesne_tabanli_programlama.composition

data class Filmler( var film_id:Int,
                    var film_ad:String,
                    var film_yil:Int,
                    var kategori:Kategoriler,
                    var yonetmen:Yonetmenler){ //Diğer sınıflardan nesne oluşturarak compositon oluşturmuş oluyoruz.


}