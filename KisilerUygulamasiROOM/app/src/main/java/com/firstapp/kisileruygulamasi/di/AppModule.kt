package com.firstapp.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.firstapp.kisileruygulamasi.data.datasource.KisilerDataSource
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import com.firstapp.kisileruygulamasi.room.KisilerDao
import com.firstapp.kisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao:KisilerDao) : KisilerDataSource{
        //Bu fonksiyonu aşağıda repository nin parametresini göndermek için oluşturduk
        return KisilerDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) :KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context:Context): KisilerDao {
        //Hilt ile @ApplicationContext bu notasyon sayesinde dışarıdan parametre vermeden bize context 'i sağlıyor.
        //provideKisilerDataSource fonksiyonunu beslemek için bu fonksiyonu yazdık. Yoksa hata verir.
        //rehber.sqlite 'ı kopyalayıp database 'i tetikliyoruz.
        val vt = Room.databaseBuilder(context, Veritabani::class.java, "rehber.sqlite") //Veritabanını erişir
            .createFromAsset("rehber.sqlite").build() //Veritabanını kopyalar.
        return vt.getKisilerDao()
    }
}