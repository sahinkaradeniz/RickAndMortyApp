package com.example.data.di.source

import com.example.data.source.RemoteDataSource
import com.example.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {
    @Binds
    @Singleton
    abstract fun bindRickAndMortyRemoteSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource
}