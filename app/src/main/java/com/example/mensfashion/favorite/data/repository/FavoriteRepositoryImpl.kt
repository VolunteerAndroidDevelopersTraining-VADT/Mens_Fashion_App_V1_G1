package com.example.mensfashion.favorite.data.repository

import com.example.mensfashion.favorite.data.mapper.toDto
import com.example.mensfashion.favorite.data.remote.FavoriteService
import com.example.mensfashion.favorite.data.remote.dto.FavoriteDto
import com.example.mensfashion.favorite.domain.model.Favorite
import com.example.mensfashion.favorite.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(
    private val favoriteService: FavoriteService
) : FavoriteRepository {
    override suspend fun insertToFavorite(Favorite: Favorite) {
        favoriteService.insertToFavorite(Favorite.toDto())
    }

    override fun getFavorite(): Flow<List<Favorite>> {
        return favoriteService.getFavorite()
    }

    override fun inFavorite(id: Int): Flow<Boolean> {
        return favoriteService.inFavorite(id)
    }

    override fun getOneFavoriteItem(id: Int): Flow<Favorite?> {
        return favoriteService.getOneFavoriteItem(id)
    }

    override suspend fun deleteOneFavorite(Favorite: Favorite) {
        favoriteService.deleteAFavorite(Favorite.toDto())
    }

    override suspend fun deleteAllFavorite() {
        favoriteService.deleteAllFavorite()
    }
}