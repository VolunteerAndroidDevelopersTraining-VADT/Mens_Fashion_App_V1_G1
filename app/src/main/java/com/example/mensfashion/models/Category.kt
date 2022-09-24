package com.example.mensfashion.models

data class Category(
    val category_id: Int = 0,
    val category_name: String = "",
    val section: Section = Section()
)