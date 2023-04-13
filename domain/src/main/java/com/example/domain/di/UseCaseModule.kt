package com.example.domain.di

import com.example.domain.usecase.getLocations.GetRickAndMortyLocationsUseCase
import com.example.domain.usecase.getLocations.GetRickAndMortyLocationsUseCaseImpl
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
    abstract fun bindGetAnimeLocationsUseCase(getRickAndMortyLocationsUseCaseImpl: GetRickAndMortyLocationsUseCaseImpl):GetRickAndMortyLocationsUseCase
}