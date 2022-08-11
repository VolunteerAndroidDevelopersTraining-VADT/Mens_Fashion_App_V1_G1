package com.example.mensfashion.core

import android.view.View

class ViewExtension {
}

 infix fun View.onclick(onClick:()->Unit) {
    setOnClickListener{
        onClick()
    }
}