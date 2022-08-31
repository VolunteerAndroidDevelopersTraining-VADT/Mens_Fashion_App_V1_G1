package com.example.mensfashion.ui.details

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseRecyclerAdapter
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.ItemSizeBinding
import com.example.mensfashion.models.Size

class SizeAdapter :BaseRecyclerAdapter<Size>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =ItemSizeBinding
        .inflate(LayoutInflater.from(parent.context),parent,false)
    override fun bind(binding: ViewDataBinding, position: Int) {
        binding as ItemSizeBinding
       val item = currentList[position]
        binding.size.text=item.size_name
      //  binding.root.isVisible=item.isSelected
        if (item.isSelected){
            val color = android.graphics.Color.parseColor("#FF838381")
            binding.fabSize.supportBackgroundTintList=ColorStateList.valueOf(color)


        }
        binding.fabSize.onclick {
            val value =item.isSelected
            currentList.forEachIndexed { index, size ->
                if (size.isSelected){
                    size.isSelected=false
                    notifyItemChanged(index)
                }
                item.isSelected=!value
                notifyItemChanged(position)
                onItemClick(item,position,0)
            }
        }
    }
}