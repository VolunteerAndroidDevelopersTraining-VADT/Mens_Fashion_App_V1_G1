package com.example.mensfashion.core

import android.view.View

class ViewExtension {
}


infix fun View.onclick(onClick: () -> Unit) {
    this.setOnClickListener {
        onClick()
    }
}




fun View.translationXAnimation(startDelay: Long) {
    translationX = 800f
    alpha = 0f
    animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(startDelay).start()
}
fun View.translationXRightAnimation(startDelay: Long) {
    translationX = -800f
    alpha = 0f
    animate().translationX(0f).alpha(1f).setDuration(800).setStartDelay(startDelay).start()
}
fun View.translationYAnimation(startDelay: Long,yValue:Float?=null) {
    translationY = yValue?:-800f
    alpha = 0f
    animate().translationY(0f).alpha(1f).setDuration(800).setStartDelay(startDelay).start()
}


