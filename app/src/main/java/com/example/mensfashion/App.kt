package com.example.mensfashion

import android.app.Application
import android.content.Context


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    companion object {
        private var instance: App? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }
}