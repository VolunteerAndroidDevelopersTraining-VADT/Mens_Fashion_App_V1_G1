package com.example.mensfashion.core.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter


abstract class BaseRecyclerAdapter2<T, vB : ViewDataBinding>(itemLDiff: BaseItemDiff<T>) : ListAdapter<T, BaseViewHolder<vB>>(itemLDiff) {

    override fun onBindViewHolder(holder: BaseViewHolder<vB>, position: Int) {
        bind(holder.binding, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = getViewHolder(parent, viewType)

    open fun getViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(createBinding(parent, viewType))

    abstract fun createBinding(parent: ViewGroup, viewType: Int): vB

    protected abstract fun bind(binding: vB, position: Int)

    var onItemClick: (item: T, position: Int, type: Int) -> Unit = { _, _, _ -> }


}