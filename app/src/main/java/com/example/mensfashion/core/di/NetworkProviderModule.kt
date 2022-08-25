package com.example.mensfashion.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.mensfashion.core.datasourcce.service.ApiService
import com.example.mensfashion.core.datasourcce.service.LocalService
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProviderModule {


    @Provides
    @Singleton
    fun provideApiService(@Named("normalRetrofit")retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideLocalService(): LocalService =LocalService()



}
