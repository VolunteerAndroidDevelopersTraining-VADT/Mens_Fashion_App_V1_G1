package com.example.mensfashion.core.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding>>() {

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = getViewHolder(parent, viewType)

    open fun getViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(createBinding(parent, viewType))

    abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding

    protected abstract fun bind(binding: ViewDataBinding, position: Int)

    var onItemClick: (item: T, position: Int, type: Int) -> Unit = { _, _, _ -> }

    val currentList = mutableListOf<T>()

    fun submitList(list: List<T>) {
        if (currentList.isNotEmpty()) {
            val lastSiz = currentList.size
            currentList.clear()
            notifyItemRangeRemoved(0, lastSiz)
        }
        currentList.addAll(list)
        notifyItemRangeInserted(0, currentList.size)
    }

    override fun getItemCount() = currentList.size
}