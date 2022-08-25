package com.example.mensfashion.core.datasourcce.interceptor

import com.example.mensfashion.core.SecureSharedPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class StatusCodeInterceptor @Inject constructor(pref: SecureSharedPreferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}