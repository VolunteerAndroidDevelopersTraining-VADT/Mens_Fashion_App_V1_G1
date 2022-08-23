package com.example.mensfashion.ui.favorites.view_model

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData

import com.example.mensfashion.core.base.BaseResponse
import com.example.mensfashion.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(application: Application, private val favoritesRepo: FavoritesRepo) : BaseViewModel(application) {

    val loadingFavorites: LiveData<Boolean> = favoritesRepo.favoritesResponse.map { it is BaseResponse.Loading }.asLiveData()
    private val favoritesResponse = favoritesRepo.favoritesResponse.asSharedFlow()


    fun getHistoryForLab() =
        launchTask {
            favoritesRepo.getHistoryForLab(queryMap = mapOf())
        }

    private val removeFavoritesResponse = favoritesRepo.favoritesResponse.asSharedFlow()
    fun removeFavoritesItem(item: Any) =
        launchTask {
            favoritesRepo.removeItem(item)
        }

    init {
        initResponse()
    }

    private fun initResponse() {

        favoritesResponse.onSuccessCollect {
            // update adapter with the data list
            noDataList.set(it.data.data.isEmpty())
        }

        removeFavoritesResponse.onSuccessCollect {
            // update adapter with the data list
            noDataList.set(it.data.data.isEmpty())

        }


    }


    val noDataList = ObservableBoolean(false)


}