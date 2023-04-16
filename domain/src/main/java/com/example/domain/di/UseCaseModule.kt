package com.example.domain.di

import com.example.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCase
import com.example.domain.usecase.getCharacterWithId.GetCharacterWithIdUseCaseImpl
import com.example.domain.usecase.getCharacterWithLocationIds.GetCharacterLocationWithIdsUseCase
import com.example.domain.usecase.getCharacterWithLocationIds.GetCharacterLocationWithIdsUseCaseImpl
import com.example.domain.usecase.getLocationPaging.GetLocationPagingDataSourceUseCase
import com.example.domain.usecase.getLocationPaging.GetLocationPagingDataSourceUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetCharacterWithIdUseCase(getCharacterWithIdUseCaseImpl: GetCharacterWithIdUseCaseImpl):GetCharacterWithIdUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetRickAndMortyLocationPaging(getLocationPagingDataSourceUseCaseImpl: GetLocationPagingDataSourceUseCaseImpl):GetLocationPagingDataSourceUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCharactersWithLocationIds(getCharacterLocationWithIdsUseCaseImpl: GetCharacterLocationWithIdsUseCaseImpl):GetCharacterLocationWithIdsUseCase
}