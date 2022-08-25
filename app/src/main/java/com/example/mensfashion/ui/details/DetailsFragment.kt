package com.example.mensfashion.ui.details

import android.content.ContentValues.TAG
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
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
import com.google.gson.Gson
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = Gson().fromJson<Product>(ProductGson.json)

        initView(product[0])
//        binding.recyclerViewColor.apply {
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//        }
    }
 private  fun initView(product:ProductItem){
     Log.e(TAG, "initView: ${product.product_images}", )
     val sliderAdapter = SliderAdapterProductDetails(product.product_images)
     binding.productImage.setSliderAdapter(sliderAdapter)
     binding.productImage.setIndicatorAnimation(IndicatorAnimationType.WORM)
     binding.productImage.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
     binding.productImage.startAutoCycle()
//     binding.contentDetails.productDescription.text=product.product_description
//    binding.contentDetails.productName.text=product.product_name
//     binding.contentDetails.productPrice.text=product.price.new_price.toString()
          binding.productPrice.text=product.price.new_price.toString()
          binding.productDescription.text=product.product_description
       binding.productName.text=product.product_name

 }



    override fun setViewBinding(): FragmentDetailsBinding = FragmentDetailsBinding.inflate(layoutInflater)
}