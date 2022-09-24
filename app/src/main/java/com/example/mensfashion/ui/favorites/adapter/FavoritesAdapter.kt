package com.example.mensfashion.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.mensfashion.core.base.BaseRecyclerAdapter
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.RowFavoritesBinding

class FavoritesAdapter: BaseRecyclerAdapter<Any>() {
    override fun createBinding(parent: ViewGroup, viewType: Int)=RowFavoritesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    var onItemClickRemoveFav: (item: Any, position: Int) -> Unit = { _, _ -> }

    override fun bind(binding: ViewDataBinding, position: Int) {
        val item=currentList[position]
        binding as RowFavoritesBinding

        binding.root.onclick {
            onItemClick(item,position,0)
        }
    }
}