package com.firstapp.kisileruygulamasi.retrofit

import com.firstapp.kisileruygulamasi.data.entity.CRUDCevap
import com.firstapp.kisileruygulamasi.data.entity.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/ -> Base Url
    //kisiler/tum_kisiler.php -> Webservis Url

    //Tüm kişiler bizden bir veri istemediği için get ile istek atarız
    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap

    //Insert Kayıt ekleme
    //@Field("kisi_ad"):Web service ile birebir aynı olmalıdır.

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded //Türkçedesteği için
    suspend fun kaydet(@Field("kisi_ad") kisi_ad:String, @Field("kisi_tel") kisi_tel:String) : CRUDCevap //bu islem için oluşturulan sınıf çağırılır.
}