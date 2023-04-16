package com.example.domain.usecase.getCharacterWithLocationIds

import com.example.common.NetworkResult
import com.example.domain.entity.CharacterEntity
import com.example.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterLocationWithIdsUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetCharacterLocationWithIdsUseCase {
    override suspend fun invoke(urlList: List<String>): NetworkResult<List<CharacterEntity>> {
        return rickAndMortyRepository.getCharactersWithRickAndMortyLocation(urlList)
    }
}