package com.venancio.showmania.di

import com.venancio.showmania.data.repository.ShowRepository
import com.venancio.showmania.data.repository.ShowRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideShowRepository(showRepository: ShowRepositoryImpl): ShowRepository
}