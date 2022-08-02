package com.example.mensfashion.favorite.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mensfashion.core.UiEvents
import com.example.mensfashion.favorite.domain.model.Favorite
import com.example.mensfashion.favorite.domain.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: FavoriteRepository
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow: SharedFlow<UiEvents> = _eventFlow.asSharedFlow()

    val favoriteItems = repository.getFavorite()/*.value?.map { it.toDomain() }*/

    fun insertFavorite(favorite: Favorite) {
        viewModelScope.launch {
            repository.insertToFavorite(favorite)
        }
    }

    fun inFavorite(id: Int): Flow<Boolean> {
        return repository.inFavorite(id)
    }

    fun deleteFromFavorite(Favorite: Favorite) {
        viewModelScope.launch {
            repository.deleteOneFavorite(Favorite)
            _eventFlow.emit(
                UiEvents.SnackbarEvent(message = "Item removed from Favorite")
            )
        }
    }

    fun deleteAllFavorite() {
        viewModelScope.launch {
            if (favoriteItems.count() == 0) {
                _eventFlow.emit(
                    UiEvents.SnackbarEvent(message = "No Favorite items found")
                )
            } else {
                repository.deleteAllFavorite()
                _eventFlow.emit(
                    UiEvents.SnackbarEvent(message = "All items deleted from your Favorite")
                )
            }
        }
    }
}