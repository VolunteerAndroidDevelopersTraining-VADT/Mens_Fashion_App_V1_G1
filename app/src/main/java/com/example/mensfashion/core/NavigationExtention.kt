package com.example.mensfashion.core

import android.os.Bundle
import androidx.navigation.NavController

fun NavController.safeNavigation(fragmentResId:Int, action:Int){
    currentDestination?.let {
        if (it.id == fragmentResId){
            navigate(action)
        }
    }
}
fun NavController.safeNavigation(fragmentResId:Int,action:Int,bundle: Bundle){
    currentDestination?.let {
        if (it.id == fragmentResId){
            navigate(action,bundle)
        }
    }
}