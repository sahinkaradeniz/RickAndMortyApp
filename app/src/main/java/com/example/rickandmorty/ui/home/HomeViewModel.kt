package com.example.rickandmorty.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.common.onError
import com.example.common.onSuccess
import com.example.domain.usecase.getCharacterWithLocationIds.GetCharacterLocationWithIdsUseCase
import com.example.domain.usecase.getLocationPaging.GetLocationPagingDataSourceUseCase
import com.example.rickandmorty.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getLocationPagingDataSourceUseCase: GetLocationPagingDataSourceUseCase,
    private val getCharacterLocationWithIdsUseCase: GetCharacterLocationWithIdsUseCase,
    private val characterMapper: HomeUiCharacterMapper,
) : ViewModel() {
    private var _characterList = MutableLiveData<HomeUiState>()
    val characterList: LiveData<HomeUiState> get() = _characterList
    val list = getLocationPagingDataSourceUseCase.invoke().cachedIn(viewModelScope)
    fun getCharactersWithLocationIds(urlList: List<String>) {
        viewModelScope.launch {
            _characterList.postValue(HomeUiState.Loading)
            getCharacterLocationWithIdsUseCase.invoke(urlList).onError {
                _characterList.postValue(HomeUiState.Error(R.string.error))
            }.onSuccess {
                _characterList.postValue(HomeUiState.Success(characterMapper.map(it ?: emptyList())))
            }
        }
    }
}