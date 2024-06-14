package com.example.filmlerapp.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    //Perse edip listeye çevirecek sınıf.
    companion object{ //static
        fun getClient(baseUrl: String) : Retrofit{

            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .client(OkHttpClient.Builder().build()).build()
        }
    }
}