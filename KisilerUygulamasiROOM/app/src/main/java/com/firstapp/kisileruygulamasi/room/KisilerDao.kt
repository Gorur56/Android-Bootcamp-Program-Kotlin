package com.firstapp.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.firstapp.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    //Burada Kisler sınıfında oluşturduğumuz database 'ide kayıtları liste haline getiyoruz.
    @Query("SELECT * FROM kisiler")

    suspend fun kisileriYukle() : List<Kisiler>

    //Kayıt,Sil, Update
    @Insert
    suspend fun kaydet(kisi:Kisiler)

    @Update
    suspend fun guncelle(kisi:Kisiler)

    @Delete
    suspend fun sil(kisi: Kisiler)
}