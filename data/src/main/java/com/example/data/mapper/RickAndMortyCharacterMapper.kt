package com.example.data.mapper

import com.example.common.mapper.Mapper
import com.example.common.util.extractIdsFromUrls
import com.example.data.dto.character.CharacterResponse
import com.example.domain.entity.CharacterEntity
import javax.inject.Inject

class RickAndMortyCharacterMapper @Inject constructor():Mapper<CharacterResponse,CharacterEntity> {
    override fun map(input: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            id = input.id,
            image = input.image,
            species = input.species,
            gender = input.gender,
            type = input.type,
            created = input.created,
            status = input.status,
            name = input.name,
            location = input.location.name,
            origin = input.origin.name,
            episodes = extractIdsFromUrls(input.episode).toString()
        )
    }
}