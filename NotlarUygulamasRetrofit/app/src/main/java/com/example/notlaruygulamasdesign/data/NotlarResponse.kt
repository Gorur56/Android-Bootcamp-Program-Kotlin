package com.example.notlaruygulamasdesign.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NotlarResponse ( @SerializedName("notlar")
                            @Expose
                            var notlar:List<Notlar>,
                            @SerializedName("success")
                            @Expose
                            var success:Int) {
}