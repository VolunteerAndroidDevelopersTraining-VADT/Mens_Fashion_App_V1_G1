package com.example.mensfashion.di

import com.example.mensfashion.favorite.data.remote.FavoriteService
import com.example.mensfashion.favorite.data.repository.FavoriteRepositoryImpl
import com.example.mensfashion.favorite.domain.repository.FavoriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {

    @Provides
    @Singleton
    fun provideFavoriteService(
    ) = FavoriteService()

    @Provides
    @Singleton
    fun provideFavoriteRepository(favoriteService: FavoriteService): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteService)
    }
}