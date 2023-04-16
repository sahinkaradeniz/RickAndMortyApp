package com.example.data.di.mapper

import com.example.common.mapper.ListMapper
import com.example.data.dto.character.CharacterResponse
import com.example.data.dto.location.Results
import com.example.data.mapper.RickAndMortLocationMapper
import com.example.data.mapper.RickAndMortyCharacterMapper
import com.example.domain.entity.CharacterEntity
import com.example.domain.entity.LocationEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyLocationMapper(rickAndMortLocationMapper: RickAndMortLocationMapper): ListMapper<Results, LocationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyCharacterMapper(rickAndMortyCharacterMapper: RickAndMortyCharacterMapper): ListMapper<CharacterResponse, CharacterEntity>
}