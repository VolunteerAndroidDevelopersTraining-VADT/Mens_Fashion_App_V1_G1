package com.example.mensfashion.ui.details

import android.app.Application
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mensfashion.core.base.BaseViewModel
import com.example.mensfashion.models.Product
import com.example.mensfashion.models.ProductItem
import com.example.mensfashion.utils.ColorAndSizeStates
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(application: Application):BaseViewModel(application) {
    val colorVisibility= ObservableField(false)
    val sizeVisibility= ObservableField(false)
    val sizeTextVisibility= ObservableField(false)
    val coloTextVisibility= ObservableField(false)
    val productPrice = MutableLiveData("")
    val productDescription = ObservableField("")
    val  productName= ObservableField("")
    var selectionState= ColorAndSizeStates.NON
    lateinit var    colorAdapter:ColorAdapter
    lateinit var   sizeAdapter:SizeAdapter
    lateinit var  sliderAdapter:SliderAdapterProductDetails
    var quantity = -1



    fun initView(product:ProductItem) {
      sliderAdapter = SliderAdapterProductDetails(product.product_images)
      sizeAdapter = SizeAdapter()
      colorAdapter=ColorAdapter()
      productPrice.value=(product.price.new_price.toString().plus(" $"))
      productDescription.set(product.product_description)
      productName.set(product.product_name)

      colorAdapter.apply {
          submitList(product.color)
          onItemClick={item, position, _ ->
              if (item.isSelected){
                  if (item.sizes.isNotEmpty()) {
                      sizeTextVisibility.set(true)
                      sizeVisibility.set(true)
                      sizeAdapter.submitList(item.sizes)
                      selectionState = ColorAndSizeStates.COLOR_AND_SIZE
                      quantity = -1
                  } else{
                      sizeTextVisibility.set(false)
                      sizeVisibility.set(false)
                      quantity=item.quantity
                      selectionState=ColorAndSizeStates.ONLY_COLOR

                  }


              }else{

                  sizeAdapter.submitList(listOf())
              }

          }
      }
      sizeAdapter.apply {
          onItemClick = { item, position, _ ->
              if (item.isSelected) {
                  quantity = item.quantity
              } else {
                  quantity = -1
              }

          }
      }
      when {
          product.color.isEmpty() && product.size.isEmpty() -> {
               hiddenColor()
               hiddenColor()
              selectionState = ColorAndSizeStates.No_SIZE_AND_COLOR
          }
          product.color.isEmpty() && product.size.isNotEmpty() -> {
              hiddenColor()
              showSize()
              selectionState = ColorAndSizeStates.ONLY_SIZE


          }
          product.color.isNotEmpty() && product.size.isEmpty() -> {
              hiddenSize()
              showColor()
              selectionState = ColorAndSizeStates.ONLY_COLOR

          }
          else -> {
              selectionState = ColorAndSizeStates.NON

          }
      }

  }
   fun onFavouriteClick(){
       Log.e(TAG, "onFavouriteClick: ", )
   }
    fun onBackClick(){
        Log.e(TAG, "onBackClick: ", )
    }

    init {
        val product = Gson().fromJson<Product>(ProductGson.json)
        initView(product = product[0])
    }
    private fun showColor(){
        colorVisibility.set(true)
        coloTextVisibility.set(true)
    }
    private fun hiddenSize() {
        sizeVisibility.set(false)
        sizeTextVisibility.set(false)

    }
    private fun showSize(){
        sizeVisibility.set(true)
        sizeTextVisibility.set(true)
    }

    private fun hiddenColor() {
        colorVisibility.set(false)
        coloTextVisibility.set(false)

    }


}