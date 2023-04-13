package com.example.data.di.mapper

import com.example.common.mapper.ListMapper
import com.example.common.mapper.Mapper
import com.example.data.dto.location.Results
import com.example.data.mapper.RickAndMortLocationMapper
import com.example.domain.dto.LocationEntity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyLocationMapper(rickAndMortLocationMapper: RickAndMortLocationMapper): ListMapper<Results, LocationEntity>
}