package com.firstapp.kisileruygulamasi.di

import com.firstapp.kisileruygulamasi.data.datasource.KisilerDataSource
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource(collectionKisiler: CollectionReference) : KisilerDataSource{
        //Bu fonksiyonu aşağıda repository nin parametresini göndermek için oluşturduk
        return KisilerDataSource(collectionKisiler)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) :KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideCollectionReference() : CollectionReference{
        //Firebase tablo oluştur
        return Firebase.firestore.collection("Kisiler")
    }
}