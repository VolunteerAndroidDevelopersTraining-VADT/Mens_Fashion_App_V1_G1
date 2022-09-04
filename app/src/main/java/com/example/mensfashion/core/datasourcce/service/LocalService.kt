package com.example.mensfashion.core.datasourcce.service

import com.example.mensfashion.ui.favorites.data.ListOfFavoriteProductsResponse
import kotlinx.coroutines.delay


class LocalService {

    suspend fun getListOfFavoriteProducts(): ListOfFavoriteProductsResponse {
        delay(3000)
        return ListOfFavoriteProductsResponse(
            "",
            ListOfFavoriteProductsResponse.FavoriteResponseData(listOf(), 1, 0)
        )
    }
    suspend fun removeItemFromListOfFavoriteProducts(item:Any): ListOfFavoriteProductsResponse {
        delay(3000)
        return ListOfFavoriteProductsResponse(
            "",
            ListOfFavoriteProductsResponse.FavoriteResponseData(listOf(), 1, 0)
        )
    }
}