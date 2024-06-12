package com.firstapp.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Query
import com.firstapp.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    //Burada Kisler sınıfında oluşturduğumuz database 'ide kayıtları liste haline getiyoruz.
    @Query("SELECT * FROM kisiler")

    suspend fun kisileriYukle() : List<Kisiler>
}