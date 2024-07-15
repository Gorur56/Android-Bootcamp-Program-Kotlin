package com.example.notlaruygulamasdesign.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUDResponse( @SerializedName("not_id")
                         @Expose
                         var success: Int,
                         @SerializedName("message")
                         @Expose
                         var message:String){
}