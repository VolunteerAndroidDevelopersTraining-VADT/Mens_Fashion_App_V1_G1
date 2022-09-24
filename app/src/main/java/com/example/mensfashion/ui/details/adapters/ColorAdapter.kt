package com.example.mensfashion.ui.details.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseRecyclerAdapter
import com.example.mensfashion.core.base.BaseViewHolder
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.ColorItemBinding
import com.example.mensfashion.models.Color


class ColorAdapter : BaseRecyclerAdapter<Color>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =ColorItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false)

    override fun bind(binding: ViewDataBinding, position: Int) {
        val item = currentList[position]
        binding as ColorItemBinding
        try{
            if (item.color_value.length>3) {
                val color = android.graphics.Color.parseColor(item.color_value)
                binding.colorShape.supportBackgroundTintList=ColorStateList.valueOf(color)


            }
        }catch(e:Exception){

        }

        if (item.isSelected){
            binding.colorShape.setImageResource(R.drawable.ic_check)
        }
        binding.colorShape.onclick {
            val value =item.isSelected
            currentList.forEachIndexed { index, color ->
                if (color.isSelected){
                    color.isSelected=false
                    notifyItemChanged(index)
                }
                item.isSelected=!value
                notifyItemChanged(position)
                onItemClick(item,position,0)
            }
        }
    }

   

    class ProductViewHolder(binding: ColorItemBinding) :BaseViewHolder<ColorItemBinding>(binding){}
}