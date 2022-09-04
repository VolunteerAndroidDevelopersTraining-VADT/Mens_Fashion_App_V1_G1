package com.example.mensfashion.core.di

import android.content.Context
import com.example.mensfashion.core.SecureSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun providePref(@ApplicationContext context: Context): SecureSharedPreferences = SecureSharedPreferences.initPreferences( context)


}
