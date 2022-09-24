package com.example.mensfashion.core.base

import com.example.mensfashion.core.datasourcce.NetworkConstants.BAD_INTERNET
import com.example.mensfashion.core.datasourcce.NetworkConstants.NO_INTERNET
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.net.SocketTimeoutException

abstract class BaseRepository {


    private val defaultDispatcher = Dispatchers.IO
    protected suspend fun <T : Any> buildApi(task: suspend () -> T) = flow<BaseResponse<T>> {
        emit(BaseResponse.Success(data = task()))
    }
        .flowOn(defaultDispatcher)
        .onStart { emit(BaseResponse.Loading(loading = true)) }
        .catch { throwable ->
            Timber.e("throwable -> ${throwable.message}")
            Timber.e("throwable -> ${throwable.cause}")
            emit(BaseResponse.Error(throwable = throwable, errorBody = getErrorBody(throwable)))
        }


    protected suspend fun buildRoom(task: suspend () -> Any?) = withContext(defaultDispatcher) {
        task()
    }


    private fun getErrorBody(throwable: Throwable): BaseErrorServerResponse = when (throwable) {
        is SocketTimeoutException -> BaseErrorServerResponse(BAD_INTERNET, "")
        is HttpException -> BaseErrorServerResponse(
            throwable.response()?.code()!!,
            throwable.response()?.errorBody()?.string()!!
        )
        else -> BaseErrorServerResponse(NO_INTERNET, "")
    }
}