package com.example.sozlukuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Kelimeler( @SerializedName("kelime_id")
                      @Expose
                      var id: Int,
                      @SerializedName("ingilizce")
                      @Expose
                      var ingilizce: String,
                      @SerializedName("turkce")
                      @Expose
                      var turkce: String ) : Serializable {
}