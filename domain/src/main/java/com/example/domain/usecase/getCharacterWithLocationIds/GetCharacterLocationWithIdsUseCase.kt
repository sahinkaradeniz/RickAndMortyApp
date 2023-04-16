package com.example.domain.usecase.getCharacterWithLocationIds

import com.example.common.NetworkResponseState
import com.example.common.NetworkResult
import com.example.domain.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface GetCharacterLocationWithIdsUseCase {
    suspend operator  fun invoke(urlList: List<String>): NetworkResult<List<CharacterEntity>>
}