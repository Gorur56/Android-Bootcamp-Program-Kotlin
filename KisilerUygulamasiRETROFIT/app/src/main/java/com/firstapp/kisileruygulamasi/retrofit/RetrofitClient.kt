package com.firstapp.kisileruygulamasi.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

//addConverterFactory(): Json dosyasını sınıflara çevirir.
class RetrofitClient {
    companion object {//static
    fun getClient(baseUrl:String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    }
}