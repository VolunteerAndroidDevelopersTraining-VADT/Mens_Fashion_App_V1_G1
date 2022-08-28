package com.example.mensfashion.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.ViewDataBinding
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseRecyclerAdapter
import com.example.mensfashion.core.base.BaseViewHolder
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.ColorItemBinding
import com.example.mensfashion.models.Color

class ProductColorAdapter : BaseRecyclerAdapter<Any>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =ColorItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false)

    override fun bind(binding: ViewDataBinding, position: Int) {
        val item =currentList[position] as Color
        binding as ColorItemBinding
        binding.colorShape.setBackgroundColor(item.color_value.toInt())
        binding.colorShape.onclick {
              onItemClick(Any(),9,0)

           }

        }



    class ProductViewHolder(binding: ColorItemBinding) :BaseViewHolder<ColorItemBinding>(binding){}
}