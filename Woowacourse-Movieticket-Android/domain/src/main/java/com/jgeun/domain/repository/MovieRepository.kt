package com.jgeun.domain.repository

import androidx.paging.PagingData
import com.jgeun.domain.model.MovieInfoModel
import com.jgeun.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun fetchMovieList(): Flow<PagingData<MovieModel>>

    fun fetchMovieInfo(code: String): Flow<MovieInfoModel>
}