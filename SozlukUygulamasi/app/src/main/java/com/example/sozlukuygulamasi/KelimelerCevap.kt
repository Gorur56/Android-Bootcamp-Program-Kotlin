package com.example.sozlukuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KelimelerCevap(  @SerializedName
                            @Expose
                            var kelimeler: List<Kelimeler>,
                            @SerializedName
                            @Expose
                            var success: Int) {

}