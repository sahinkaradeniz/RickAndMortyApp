package com.example.domain.usecase.getCharacterWithLocationIds

import com.example.common.NetworkResult
import com.example.domain.entity.CharacterEntity

interface GetCharacterLocationWithIdsUseCase {
    suspend operator  fun invoke(urlList: List<String>): NetworkResult<List<CharacterEntity>>
}