package com.example.mensfashion.utils

sealed class ResponseResult<T>{

        data class Success<T>(val data: T) : ResponseResult<T>()
        data class Error<T>(val exception: String) : ResponseResult<T>()
        object Loading : ResponseResult<Nothing>()


}