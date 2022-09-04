package com.example.mensfashion.core.base


sealed class BaseResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : BaseResponse<T>()
    data class Error(val throwable: Throwable, val errorBody: BaseErrorServerResponse) : BaseResponse<Nothing>()
    data class Loading(val loading: Boolean) : BaseResponse<Nothing>()
    object None : BaseResponse<Nothing>()
}