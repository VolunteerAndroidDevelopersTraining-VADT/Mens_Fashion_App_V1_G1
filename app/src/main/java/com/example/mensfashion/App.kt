package com.example.mensfashion

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.mensfashion.core.SecureSharedPreferences


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        pref = SecureSharedPreferences.initPreferences(this)
    }


    companion object {
        private var instance: App? = null
        lateinit var pref: SecureSharedPreferences
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }
}