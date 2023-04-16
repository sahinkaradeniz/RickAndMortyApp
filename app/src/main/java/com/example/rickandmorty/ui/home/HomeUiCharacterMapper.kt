package com.example.rickandmorty.ui.home

import com.example.common.mapper.ListMapper
import com.example.domain.entity.CharacterEntity
import javax.inject.Inject

class HomeUiCharacterMapper @Inject constructor():
    ListMapper<CharacterEntity, HomeCharacterUiData> {
    override fun map(input: List<CharacterEntity>): List<HomeCharacterUiData> {
        return input.map {
            HomeCharacterUiData(
                id = it.id,
                name = it.name,
                image = it.image,
                gender = it.gender
            )
        }
    }

}