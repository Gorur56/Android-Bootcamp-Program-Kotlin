package com.firstapp.kisileruygulamasi.di

import com.firstapp.kisileruygulamasi.data.datasource.KisilerDataSource
import com.firstapp.kisileruygulamasi.data.repo.KisilerRepository
import com.firstapp.kisileruygulamasi.retrofit.ApiUtils
import com.firstapp.kisileruygulamasi.retrofit.KisilerDao
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
    fun provideKisilerDataSource(kdao:KisilerDao) : KisilerDataSource {
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
    fun provideKisilerDao() : KisilerDao {
        return ApiUtils.getKisilerDao()
    }
}