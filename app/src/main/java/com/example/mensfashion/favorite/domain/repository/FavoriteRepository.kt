package com.example.mensfashion.favorite.domain.repository

import com.example.mensfashion.favorite.domain.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun insertToFavorite(Favorite: Favorite)
    fun getFavorite(): Flow<List<Favorite>>
    fun inFavorite(id: Int): Flow<Boolean>
    fun getOneFavoriteItem(id: Int): Flow<Favorite?>
    suspend fun deleteOneFavorite(Favorite: Favorite)
    suspend fun deleteAllFavorite()
}