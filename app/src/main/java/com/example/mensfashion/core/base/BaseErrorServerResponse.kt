package com.example.mensfashion.core.base

import com.google.gson.annotations.SerializedName

data class BaseErrorServerResponse(
    @SerializedName("statusCode")
    val statusCode:Int,
    @SerializedName("errorMessage")
    val errorMessage:String)
