package com.example.mensfashion.core

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mensfashion.R

class ViewExtension {
}


infix fun View.onclick(onClick: () -> Unit) {
    this.setOnClickListener {
        onClick()
    }
}

fun ImageView.loadImage(view:View, imageView: ImageView, scr:String){
    Glide.with(view)
        .load(scr)
        .fitCenter().placeholder(R.drawable.splash_1)
        .into(imageView)
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
fun View.translationYAnimation(startDelay: Long) {
    translationY = -800f
    alpha = 0f
    animate().translationY(0f).alpha(1f).setDuration(800).setStartDelay(startDelay).start()
}