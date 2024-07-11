package com.example.sozlukuygulamasi.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KelimelerCevap(@SerializedName("kelimeler")
                          @Expose
                          var kelimeler: List<Kelimeler>,
                          @SerializedName("success")
                          @Expose
                          var success: Int) {

}