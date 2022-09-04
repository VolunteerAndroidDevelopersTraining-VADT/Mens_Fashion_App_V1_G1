package com.example.mensfashion

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.hilt.work.HiltWorkerFactory
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.work.Configuration
import com.example.mensfashion.core.SecureSharedPreferences
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App : Application() , ViewModelStoreOwner, Configuration.Provider {
    @Inject
    lateinit var workerFactory: HiltWorkerFactory
    override fun getWorkManagerConfiguration() = Configuration.Builder()
        .setWorkerFactory(workerFactory)
        .setMinimumLoggingLevel(android.util.Log.DEBUG)
        .build()
    override fun getViewModelStore() = appViewModelStore

    val OFFLINE = true
    override fun onCreate() {
        super.onCreate()
        instance = this
        initTimber()
        pref = SecureSharedPreferences.initPreferences(this)
        if (BuildConfig.DEBUG) {
            // to just log when app is debug
            Timber.plant(Timber.DebugTree())
        }

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // prevent dark mode
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        private val appViewModelStore: ViewModelStore by lazy {
            ViewModelStore()
        }

        const val OFFLINE = true
        private var instance: App? = null
        lateinit var pref: SecureSharedPreferences
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }


}