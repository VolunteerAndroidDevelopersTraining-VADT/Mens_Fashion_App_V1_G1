package com.example.mensfashion.favorite.domain.model

data class Favorite(
    val image: String,
    val price: Double,
    val title: String,
    val category: String,
    val description: String,
    val rating: Rating,
    val id: Int,
    val liked: Boolean = false,
)