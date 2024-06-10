package com.example.hiltkullanimi.di

import com.example.hiltkullanimi.Adres
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Veriyi veren kısım
    @Provides
    @Singleton
    //Singleton Pattern bir nesne oluşturup birçok class 'ta kullanıyoruz.
    //Internes ve Kargo Adres istiyor. Bunu sağlayacak bir fonksiyon yazacağız.
    fun provideAdres() : Adres{
        return Adres("Kadıköy / Istanbul")
    }
}