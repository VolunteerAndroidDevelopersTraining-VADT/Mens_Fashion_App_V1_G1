package com.example.mensfashion.favorite.data.remote.dto

data class FavoriteDto(
    val image: String,
    val price: Double,
    val title: String,
    val category: String,
    val description: String,
    val rating: RatingDto,
    val liked: Boolean = false,
    val id: Int,
)