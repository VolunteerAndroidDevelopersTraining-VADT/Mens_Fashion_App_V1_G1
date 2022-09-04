package com.example.mensfashion.ui.favorites.view_model

import com.example.mensfashion.App
import com.example.mensfashion.core.base.BaseRepository
import com.example.mensfashion.core.base.BaseResponse
import com.example.mensfashion.core.datasourcce.service.ApiService
import com.example.mensfashion.core.datasourcce.service.LocalService
import com.example.mensfashion.ui.favorites.data.ListOfFavoriteProductsResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import javax.inject.Inject

class FavoritesRepo @Inject constructor(
    private val apiService: ApiService,
    private val localService: LocalService,
) : BaseRepository() {

    val favoritesResponse = MutableSharedFlow<BaseResponse<ListOfFavoriteProductsResponse>>(0)
    suspend fun getHistoryForLab(queryMap: Map<String, String>) {
        if (App.OFFLINE) {
            favoritesResponse.emitAll(flow = buildApi {
                localService.getListOfFavoriteProducts()
            })
            return
        }
        favoritesResponse.emitAll(flow = buildApi {
            apiService.getListOfFavoriteProducts()
        })
    }

    val removeFavoritesResponse = MutableSharedFlow<BaseResponse<ListOfFavoriteProductsResponse>>(0)
    suspend fun removeItem(item:Any) {
        if (App.OFFLINE) {
            removeFavoritesResponse.emitAll(flow = buildApi {
                localService.removeItemFromListOfFavoriteProducts(item)
            })
            return
        }

        removeFavoritesResponse.emitAll(flow = buildApi {
            apiService.removeItemFromListOfFavoriteProducts(item)
        })
    }

}