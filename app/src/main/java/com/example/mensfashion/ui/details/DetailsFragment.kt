package com.example.mensfashion.ui.details

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.FragmentDetailsBinding
import com.example.mensfashion.models.Product
import com.example.mensfashion.models.ProductItem
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.recyclerViewColor.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        }
    }
 private  fun initView(product:ProductItem){
     val sliderAdapter = SliderAdapterProductDetails(product.product_images)
     binding.productImage.setSliderAdapter(sliderAdapter)
     binding.productImage.setIndicatorAnimation(IndicatorAnimationType.WORM)
     binding.productImage.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
     binding.productImage.startAutoCycle()
 }



    override fun setViewBinding(): FragmentDetailsBinding = FragmentDetailsBinding.inflate(layoutInflater)
}