package com.example.mensfashion.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.mensfashion.core.base.BaseItemDiff
import com.example.mensfashion.core.base.BaseRecyclerAdapter
import com.example.mensfashion.core.base.BaseRecyclerAdapter2
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.RowFavoritesBinding
import com.example.mensfashion.ui.favorites.data.FavoriteItem

class FavoritesAdapter : BaseRecyclerAdapter2<FavoriteItem, RowFavoritesBinding>(object : BaseItemDiff<FavoriteItem>() {
    override fun areContentsTheSame(oldItem: FavoriteItem, newItem: FavoriteItem) = oldItem.id == newItem.id
}) {
    override fun createBinding(parent: ViewGroup, viewType: Int) = RowFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    var onItemClickRemoveFav: (item: Any, position: Int) -> Unit = { _, _ -> }

    override fun bind(binding: RowFavoritesBinding, position: Int) {
        val item = currentList[position]
        binding.root.onclick {
            onItemClick(item, position, 0)
        }
    }

}