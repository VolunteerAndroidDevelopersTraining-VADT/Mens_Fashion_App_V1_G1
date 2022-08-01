package com.example.mensfashion.core

import android.view.View

class ViewExtension {
}

fun View.onclick(onClick:()->Unit) {
    this.setOnClickListener{
        onClick()
    }
}