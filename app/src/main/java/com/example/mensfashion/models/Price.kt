package com.example.mensfashion.models

data class Price(
    val cane_request_more_then_one: Boolean = false,
    val expire_date: String = "",
    val hase_offer: Boolean = false,
    val new_price: Double = 0.0,
    val old_price: Double = 0.0
)