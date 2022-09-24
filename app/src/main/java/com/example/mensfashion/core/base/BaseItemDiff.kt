package com.example.mensfashion.core.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

open class BaseItemDiff<T> : DiffUtil.ItemCallback<T>() {
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}