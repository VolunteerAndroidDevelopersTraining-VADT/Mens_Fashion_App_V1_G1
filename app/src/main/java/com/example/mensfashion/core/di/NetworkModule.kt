package com.example.mensfashion.core.di

import android.content.Context
import androidx.viewbinding.BuildConfig
import com.example.mensfashion.core.SecureSharedPreferences
import com.example.mensfashion.core.datasourcce.NetworkConstants
import com.example.mensfashion.core.datasourcce.NetworkConstants.CACHE_SIZE
import com.example.mensfashion.core.datasourcce.interceptor.SSLCertificate.getUnsafeOkHttpClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.mensfashion.core.datasourcce.interceptor.HeaderInterceptor
import com.example.mensfashion.core.datasourcce.interceptor.StatusCodeInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //Hilt Provide Network Cache
    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, CACHE_SIZE)

    //
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }

    //
    @Provides
    @Singleton
    fun provideHeaderInterceptor(pref: SecureSharedPreferences): HeaderInterceptor = HeaderInterceptor(pref)

    //
    @Provides
    @Singleton
    fun provideStatusCodeInterceptor(pref: SecureSharedPreferences): StatusCodeInterceptor =
        StatusCodeInterceptor(pref)

    //
    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        headerInterceptor: HeaderInterceptor,
        statusCodeInterceptor: StatusCodeInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = getUnsafeOkHttpClient().apply {
            connectTimeout(NetworkConstants.timeOut, TimeUnit.SECONDS)
            readTimeout(NetworkConstants.timeOut, TimeUnit.SECONDS)
            writeTimeout(NetworkConstants.timeOut, TimeUnit.SECONDS)
            addInterceptor(headerInterceptor)
            addInterceptor(statusCodeInterceptor)
            addInterceptor(loggingInterceptor)
            cache(cache)
        }.build()


    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    //
    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    //
    @Provides
    @Singleton
    @Named("normalRetrofit")
    fun provideRetrofit(converterFactory: GsonConverterFactory,okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()



}
