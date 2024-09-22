package com.example.filmlerappdesign.entity

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Filmler(
    var film_id:String?="",
    var film_ad:String?="",
    var film_yil:Int?=0,
    var film_resim:String?="",
    var kategoriler: String?="",
    var yonetmen_ad: String?=""
) : Serializable {
}