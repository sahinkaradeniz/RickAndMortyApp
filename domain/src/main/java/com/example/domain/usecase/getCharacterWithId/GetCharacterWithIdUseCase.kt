package com.example.domain.usecase.getCharacterWithId

import com.example.common.NetworkResult
import com.example.domain.entity.CharacterEntity

interface GetCharacterWithIdUseCase{
    suspend operator fun invoke(id:String):NetworkResult<CharacterEntity>
}