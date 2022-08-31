package com.example.mensfashion.ui.details

import android.content.ContentValues.TAG
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.FragmentDetailsBinding
import com.example.mensfashion.models.Product
import com.example.mensfashion.models.ProductItem
import com.example.mensfashion.ui.favorites.view_model.FavoritesViewModel
import com.example.mensfashion.utils.ColorAndSizeStates
import com.google.gson.Gson
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(){
    val viewModel by viewModels<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm=viewModel
        initView()


    }

    private fun initSizeRecycle() {

        binding.recyclerViewSize.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = viewModel.sizeAdapter
        }
    }
    private fun initColorRecycle() {
        binding.recyclerViewColor.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter=viewModel.colorAdapter

        }

    }

    private  fun initView(){
        initColorRecycle()
        initSizeRecycle()
     binding.productImage.setSliderAdapter(viewModel.sliderAdapter)
     binding.productImage.setIndicatorAnimation(IndicatorAnimationType.WORM)
     binding.productImage.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
     binding.productImage.startAutoCycle()








 }



    override fun setViewBinding(): FragmentDetailsBinding = FragmentDetailsBinding.inflate(layoutInflater)
}