package com.jgeun.data.di

import com.jgeun.data.repository.DefaultMovieRepository
import com.jgeun.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsMovieRepository(defaultMovieRepository: DefaultMovieRepository): MovieRepository
}