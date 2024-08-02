package com.jgeun.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.jgeun.data.datasource.MovieListPagingSource
import com.jgeun.data.datasource.remote.MovieDataSource
import com.jgeun.data.mapper.toDomain
import com.jgeun.data.network.model.response.MovieListResponse.MovieListResultResponse.MovieDto
import com.jgeun.domain.model.MovieInfoModel
import com.jgeun.domain.model.MovieModel
import com.jgeun.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultMovieRepository @Inject constructor(
    private val movieListPagingSource: MovieListPagingSource,
    private val movieDataSource: MovieDataSource
) : MovieRepository {

    override fun fetchMovieList(): Flow<PagingData<MovieModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = SEARCH_MOVIE_PAGING_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { movieListPagingSource }
        ).flow.map { pagingData ->
            pagingData.map(MovieDto::toDomain)
        }
    }

    override fun fetchMovieInfo(code: String): Flow<MovieInfoModel> = flow {
        val movieInfo = movieDataSource.fetchMovieInfo(code)
        emit(movieInfo.movieInfoResult.movieInfoDto.toDomain())
    }

    companion object {
        private const val SEARCH_MOVIE_PAGING_SIZE = 10
    }
}