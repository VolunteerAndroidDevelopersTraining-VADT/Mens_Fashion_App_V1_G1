package com.example.mensfashion.favorite.data.remote

import com.example.mensfashion.favorite.data.mapper.toDomain
import com.example.mensfashion.favorite.data.remote.dto.FavoriteDto
import com.example.mensfashion.favorite.data.remote.dto.RatingDto
import com.example.mensfashion.favorite.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
* This file will contain Retrofit service,
* but for now it will be a normal class until we build the backend
*
* Attia Ali
* */

class FavoriteService {

    private val favorites = mutableSetOf<FavoriteDto>(
        FavoriteDto(
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            2.3, "AS", "ddd", "Photos", RatingDto(12, 2.3), true, 1
        ),
        FavoriteDto(
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            5.3, "BG", "ccc", "dsa", RatingDto(12, 2.3), false, 2
        )
    )

    fun insertToFavorite(favortieItem: FavoriteDto) {
        favorites.add(favortieItem)
    }

    fun getFavorite(): Flow<List<Favorite>> {
        return flow {
            emit(
                favorites.map {
                    it.toDomain()
                }.toList()
            )
        }
    }

    fun inFavorite(id: Int): Flow<Boolean> {
        return flow {
            emit(favorites.any {
                it.id == id
            })
        }
    }

    fun getOneFavoriteItem(id: Int): Flow<Favorite?> {
        return flow {
            emit(favorites.firstOrNull {
                it.id == id
            }?.toDomain())
        }
    }

    fun deleteAFavorite(favorite: FavoriteDto) {
        favorites.remove(favorite)
    }

    fun deleteAllFavorite() {
        favorites.clear()
    }

}