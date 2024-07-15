package com.example.notlaruygulamasdesign.Retrofit

import com.example.notlaruygulamasdesign.data.Notlar
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NotlarDaoInterface {
    @GET("notlar/tum_notlar.php")
    fun tumNotlar() : Call<Notlar>

    //Not silme
    @POST("notlar/delete_not.php")
    @FormUrlEncoded
    fun notSil(@Field("not_id") not_id: Int) : Call<CRUDResponse>

    //Not ekleme
    @POST("notlar/insert_not.php")
    @FormUrlEncoded
    fun notEkle(@Field("ders_adi") ders_adi: String
                ,@Field("not1") not1: Int
                ,@Field("not2") not2 : Int) : Call<CRUDResponse>

    //Not Guncelleme
    @POST("notlar/update_not.php")
    @FormUrlEncoded
    fun notGuncelle(@Field("not_id") not_id: Int
                    ,@Field("ders_adi") ders_adi: String
                    ,@Field("not1") not1: Int
                    ,@Field("not2") not2: Int) : Call<CRUDResponse>
}