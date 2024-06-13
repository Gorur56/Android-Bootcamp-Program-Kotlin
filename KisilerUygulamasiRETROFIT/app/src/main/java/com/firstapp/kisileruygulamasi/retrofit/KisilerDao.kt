package com.firstapp.kisileruygulamasi.retrofit

import com.firstapp.kisileruygulamasi.data.entity.KisilerCevap
import retrofit2.http.GET

interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/ -> Base Url
    //kisiler/tum_kisiler.php -> Webservis Url

    //Tüm kişiler bizden bir veri istemediği için get ile istek atarız
    @GET("kisiler/tum_kisiler.php")
    suspend fun kisleriYukle() : KisilerCevap
}