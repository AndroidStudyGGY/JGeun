package com.jgeun.data.datasource.remote

import com.jgeun.data.network.api.MovieService
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val movieService: MovieService
) {
    suspend fun fetchMovieList(
        page: String = "1",
        size: String = PAGING_SIZE
    ) = movieService.fetchMovieList(
        page = page,
        size = size
    )

    suspend fun fetchMovieInfo(code: String) =
        movieService.fetchMovieInfo(code)

    companion object {
        private const val PAGING_SIZE = "10"
    }
}