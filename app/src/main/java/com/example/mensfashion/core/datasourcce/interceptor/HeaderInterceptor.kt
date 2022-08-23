package com.example.mensfashion.core.datasourcce.interceptor

import com.example.mensfashion.core.SecureSharedPreferences
import com.example.mensfashion.core.datasourcce.NetworkConstants.TOKEN_OF_APIS
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val pref: SecureSharedPreferences) : Interceptor {

//    private val language: String get() = "ar"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
//            .addHeader("Lang", "en")
            .addHeader("Authorization", pref.retrieve(TOKEN_OF_APIS)?:"")
            .build()
        return chain.proceed(request)
    }
}