package com.example.data.mapper

import com.example.common.mapper.ListMapper
import com.example.data.dto.character.CharacterResponse
import com.example.domain.entity.CharacterEntity
import javax.inject.Inject

class RickAndMortyCharacterMapper @Inject constructor():ListMapper<CharacterResponse,CharacterEntity> {
    override fun map(input: List<CharacterResponse>): List<CharacterEntity> {
        return input.map {
             CharacterEntity(
                 id = it.id,
                 image = it.image,
                 status = it.status,
                 created = it.created,
                 type = it.type,
                 gender = it.gender,
                 species = it.species,
                 name = it.name
             )
         }
    }
}