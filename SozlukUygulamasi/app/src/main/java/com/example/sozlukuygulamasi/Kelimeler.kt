package com.example.sozlukuygulamasi

import java.io.Serializable

data class Kelimeler(
    var id: Int,
    var ingilizce: String,
    var turkce: String ) : Serializable {
}