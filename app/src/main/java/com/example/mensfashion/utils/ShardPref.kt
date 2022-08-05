package com.example.mensfashion.utils

import android.content.Context
import android.content.SharedPreferences

object ShardPref {
    private var shardPreference: SharedPreferences? = null

    fun creatPrefObj(context: Context): SharedPreferences? {
        if (shardPreference == null) {
            shardPreference = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
        }
        return shardPreference
    }

    fun setLoggedIn(loggedIn: Boolean) {
        val editor = shardPreference!!.edit()
        editor.putBoolean("logged", loggedIn)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return shardPreference!!.getBoolean("logged", false)
    }
}