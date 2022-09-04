package com.example.mensfashion.core

sealed class UiEvents {
    data class SnackbarEvent(val message: String) : UiEvents()
}