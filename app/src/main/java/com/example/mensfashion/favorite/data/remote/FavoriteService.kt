package com.example.mensfashion.favorite.data.remote

import android.util.Log
import com.example.mensfashion.favorite.data.mapper.toDomain
import com.example.mensfashion.favorite.data.remote.dto.FavoriteDto
import com.example.mensfashion.favorite.data.remote.dto.RatingDto
import com.example.mensfashion.favorite.domain.model.Favorite
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

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

    private val favFlow = MutableStateFlow<List<Favorite>> (
        favorites.map {
                it.toDomain()
            }.toList()
    )

    fun insertToFavorite(favortieItem: FavoriteDto) {
        favorites.add(favortieItem)
        temporaryEmit() // todo delete after retrofit code is ready
    }

    fun getFavorite(): Flow<List<Favorite>> {
        return favFlow
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
        temporaryEmit() // todo delete after retrofit code is ready
    }

    fun deleteAllFavorite() {
        favorites.clear()
        Log.i("TAG", "deleteAllFavorite: $favorites")
        temporaryEmit() // todo delete after retrofit code is ready
    }

    fun temporaryEmit() {
        GlobalScope.launch {
            favFlow.emit(favorites.map { it.toDomain() })
        }
    }

}