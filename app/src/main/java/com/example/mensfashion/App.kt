package com.example.mensfashion

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import android.util.Log
import com.example.mensfashion.core.SecureSharedPreferences

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initTimber()
        pref = SecureSharedPreferences.initPreferences(this)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        private var instance: App? = null
        lateinit var pref: SecureSharedPreferences
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }
}