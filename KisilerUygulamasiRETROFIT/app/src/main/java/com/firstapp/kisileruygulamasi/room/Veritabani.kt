package com.firstapp.kisileruygulamasi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.firstapp.kisileruygulamasi.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1) //Oluşturduğumuz her tabloyu buraya eklememiz gerekiyor
abstract class Veritabani : RoomDatabase() { //Soyut ve interface tabanlı bir sınıf olmalıdır.

    //Interface 'erişim ve oradaki fonksiyonları kullanma
    abstract fun getKisilerDao() : KisilerDao
}