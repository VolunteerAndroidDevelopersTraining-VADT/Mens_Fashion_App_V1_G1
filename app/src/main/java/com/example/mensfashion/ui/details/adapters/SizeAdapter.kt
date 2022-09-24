package com.example.mensfashion.ui.details.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mensfashion.core.base.BaseItemDiff
import com.example.mensfashion.core.base.BaseRecyclerAdapter2
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.ItemSizeBinding
import com.example.mensfashion.models.Size

class SizeAdapter : BaseRecyclerAdapter2<Size, ItemSizeBinding>(object : BaseItemDiff<Size>() {
    override fun areContentsTheSame(oldItem: Size, newItem: Size) = oldItem.isSelected == newItem.isSelected
}) {
    override fun createBinding(parent: ViewGroup, viewType: Int) = ItemSizeBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)

    override fun bind(binding: ItemSizeBinding, position: Int) {
        val item = currentList[position]
        binding.size.text = item.size_name
        binding.size.isSelected = item.isSelected
        binding.size.onclick {
            val value = item.isSelected
            currentList.forEachIndexed { index, size ->
                if (size.isSelected) {
                    size.isSelected = false
                    notifyItemChanged(index)
                }
                item.isSelected = !value
                notifyItemChanged(position)
                onItemClick(item, position, 0)
            }
        }
    }
}