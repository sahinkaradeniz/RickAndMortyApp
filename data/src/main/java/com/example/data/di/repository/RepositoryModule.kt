package com.example.data.di.repository

import com.example.data.repository.RickAndMortyRepositoryImpl
import com.example.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl,
    ): RickAndMortyRepository
}