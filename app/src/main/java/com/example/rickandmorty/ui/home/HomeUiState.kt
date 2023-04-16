package com.example.rickandmorty.ui.home

import androidx.annotation.StringRes

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: List<HomeCharacterUiData>) : HomeUiState()
    data class Error(@StringRes val message: Int) : HomeUiState()
}