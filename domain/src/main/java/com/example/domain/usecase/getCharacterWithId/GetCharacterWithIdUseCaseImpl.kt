package com.example.domain.usecase.getCharacterWithId

import com.example.common.NetworkResult
import com.example.domain.entity.CharacterEntity
import com.example.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterWithIdUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetCharacterWithIdUseCase {
    override suspend fun invoke(id:String): NetworkResult<CharacterEntity> {
       return rickAndMortyRepository.getRickAndMortyCharacterWithId(id)
    }
}