package com.example.mensfashion.core.datasourcce.service

import com.google.gson.annotations.SerializedName

data class BaseErrorServerResponse(
    @SerializedName("statusCode")
    val statusCode:Int,
    @SerializedName("errorMessage")
    val errorMessage:String)
