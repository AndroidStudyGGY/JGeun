package com.jgeun.domain.usecase

import com.jgeun.domain.model.MovieInfoModel
import com.jgeun.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieInfoUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(movieCode: String): Flow<MovieInfoModel> =
        movieRepository.fetchMovieInfo(movieCode)
}