package com.jgeun.domain.usecase

import androidx.paging.PagingData
import com.jgeun.domain.model.MovieModel
import com.jgeun.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<MovieModel>> =
        movieRepository.fetchMovieList()
}