package com.example.notlaruygulamasdesign.data

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Notlar(var not_id: String?="",
                  var ders_adi: String?="",
                  var not1: Int?=0,
                  var not2: Int?=0) : Serializable {
}