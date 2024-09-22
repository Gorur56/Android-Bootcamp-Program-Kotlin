package com.example.filmlerappdesign.entity

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Kategoriler(
    var kategori_id: String?="",
    var kategori_ad: String?=""
) : Serializable {
}