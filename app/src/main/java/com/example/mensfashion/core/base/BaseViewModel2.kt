package com.example.mensfashion.core.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mensfashion.core.SecureSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseViewModel(val app: Application) : AndroidViewModel(app) {
    protected fun launchTask(task: suspend () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) { task() }

    @Inject
    lateinit var pref: SecureSharedPreferences


    fun <T : Any> Flow<BaseResponse<T>>.onSuccessCollect(onSuccess: (T) -> Unit) {
        viewModelScope.launch {
            this@onSuccessCollect.collectLatest { response ->
                when (response) {
                    is BaseResponse.Loading -> Unit
                    is BaseResponse.Success -> onSuccess(response.data)
                    is BaseResponse.Error -> onError(response.errorBody)
                    is BaseResponse.None -> Unit
                }
            }
        }
    }


    private fun onError(error: BaseErrorServerResponse) {
        /*
        * this code is to handle status codes in error mode of server
        * */
        when {
            error.statusCode == 400 -> {
                // handle bad request error

            }
            error.statusCode == 401 || error.statusCode == 403 -> {
                // handle Unauthorized error

            }
            error.statusCode < 200 -> {
                // handle local error
            }
            else -> {

            }
        }

    }


}