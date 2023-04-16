package com.example.rickandmorty.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCase
import com.example.rickandmorty.R
import com.example.rickandmorty.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterWithIdUseCase: GetCharacterWithIdUseCase
): ViewModel() {
    private val _detailUiState=MutableLiveData<DetailUiState>()
    val detailUiState:LiveData<DetailUiState> get() = _detailUiState
    fun getRickAndMortyCharacter(id:String){
        viewModelScope.launch {
            getCharacterWithIdUseCase.invoke(id).onError {
               _detailUiState.postValue(DetailUiState.Error(R.string.error))
            }.onSuccess {
                _detailUiState.postValue(DetailUiState.Success(it))
            }
        }
    }
}