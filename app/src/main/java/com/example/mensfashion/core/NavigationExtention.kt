package com.example.mensfashion.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

//fun NavController.safeNavigation(fragmentResId:Int, action:Int){
//    currentDestination?.let {
//        if (it.id == fragmentResId){
//            navigate(action)
//        }
//    }
//}
//fun NavController.safeNavigation(fragmentResId:Int,action:Int,bundle: Bundle){
//    currentDestination?.let {
//        if (it.id == fragmentResId){
//            navigate(action,bundle)
//        }
//    }
//}
// using this method better or navigation in basefragment

fun NavController.safeNavigation(
    action: Int? = null,
    destination: Int? = null,
    bundle: Bundle? = null,
    navOptions: NavOptions? = null
) {
    when {
        action != null -> navigate(action, bundle, navOptions)
        destination != null -> navigate(destination, bundle, navOptions)
    }
}
fun Fragment.navigateTo(
    action: Int? = null,
    destination: Int? = null,
    bundle: Bundle? = null,
    navOptions: NavOptions? = null
) {
    try {
        findNavController().safeNavigation(action, destination, bundle, navOptions)
    } catch (e: Throwable) {
       // Timber.e(e, "Error-> ") // debug loger
    }
}