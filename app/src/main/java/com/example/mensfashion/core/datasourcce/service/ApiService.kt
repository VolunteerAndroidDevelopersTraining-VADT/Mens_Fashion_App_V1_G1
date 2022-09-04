package com.example.mensfashion.core.datasourcce.service

import com.example.mensfashion.core.datasourcce.NetworkConstants
import com.example.mensfashion.ui.favorites.data.ListOfFavoriteProductsResponse
import kotlinx.coroutines.delay
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    companion object Factory {

        // const val CUSTOM_HEADER = "@"
        // const val NO_AUTH = "NoAuth"
    }

    @GET(NetworkConstants.LIST_OF_FAVORITES)
    suspend fun getListOfFavoriteProducts(): ListOfFavoriteProductsResponse

    @POST(NetworkConstants.LIST_OF_FAVORITES)
    suspend fun removeItemFromListOfFavoriteProducts(@Body removeItem:Any): ListOfFavoriteProductsResponse

}