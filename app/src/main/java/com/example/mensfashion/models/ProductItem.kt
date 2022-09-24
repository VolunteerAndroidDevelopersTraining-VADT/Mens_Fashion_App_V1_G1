package com.example.mensfashion.models

data class ProductItem(
    val category: Category = Category(),
    val color: List<Color> = listOf(),
    val size: List<Size> = listOf(),

    val out_of_stock: Boolean = false,
    val price: Price = Price(),
    val product_description: String = "",
    val product_id: String = "",
    val product_images: List<String> = listOf(),
    val product_name: String = "",
    val quantity :Int = 0
)