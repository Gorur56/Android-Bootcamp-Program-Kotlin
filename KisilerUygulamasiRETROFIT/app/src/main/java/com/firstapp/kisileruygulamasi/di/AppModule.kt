package com.firstapp.kisileruygulamasi.di

import com.firstapp.kisileruygulamasi.data.datasource.KisilerDataSource
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
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
    fun provideKisilerDataSource() : KisilerDataSource{
        //Bu fonksiyonu aşağıda repository nin parametresini göndermek için oluşturduk
        return KisilerDataSource()
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) :KisilerRepository{
        return KisilerRepository(kds)
    }
}