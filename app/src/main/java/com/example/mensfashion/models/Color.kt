package com.example.mensfashion.models

data class Color(
    val color_id: Int = 0,
    val color_name: String = "",
    val color_value: String = "",
    val quantity: Int = 0,
    val sizes: List<Size> = listOf()
)