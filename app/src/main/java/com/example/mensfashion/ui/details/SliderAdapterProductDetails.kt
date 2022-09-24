package com.example.mensfashion.ui.details

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.example.mensfashion.R
import com.example.mensfashion.core.loadImage
import com.example.mensfashion.databinding.SliderItemProductDetailsBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapterProductDetails (private var images: List<String>) : SliderViewAdapter<SliderAdapterProductDetails.SliderHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?): SliderHolder {
        val view =SliderItemProductDetailsBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        return SliderHolder(view)
    }

    override fun onBindViewHolder(holder: SliderHolder, position: Int) {
        val itemImage=images[position]
        //using coil
        //holder.binding.imageViewDetailes.load(itemImage)
        //using Glide extension function
       holder.binding.imageViewDetailes.loadImage(holder.itemView,holder.binding.imageViewDetailes,itemImage)

    }

    override fun getCount(): Int {
        return images.size
    }

   class SliderHolder( val binding: SliderItemProductDetailsBinding) : SliderViewAdapter.ViewHolder(binding.root)

    }

