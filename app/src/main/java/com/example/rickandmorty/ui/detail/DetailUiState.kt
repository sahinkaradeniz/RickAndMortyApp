package com.example.rickandmorty.ui.detail

import androidx.annotation.StringRes
import com.example.domain.entity.CharacterEntity

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: CharacterEntity?) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()
}