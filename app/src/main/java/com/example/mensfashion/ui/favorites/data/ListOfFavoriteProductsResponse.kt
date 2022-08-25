package com.example.mensfashion.ui.favorites.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfFavoriteProductsResponse(
    @SerializedName("errorMessage")
    @Expose val error: String?,
    @SerializedName("data")
    @Expose val data: FavoriteResponseData,
) {
    data class FavoriteResponseData(
        @SerializedName("listOfData")
        @Expose val data: List<Any> = listOf(),
        @SerializedName("page")
        @Expose val page:Int,
        @SerializedName("totalCount")
        @Expose val totalCount:Int,
    )
}
