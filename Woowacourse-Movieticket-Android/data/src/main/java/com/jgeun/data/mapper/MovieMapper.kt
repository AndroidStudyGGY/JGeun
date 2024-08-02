package com.jgeun.data.mapper

import com.jgeun.data.network.model.response.MovieListResponse
import com.jgeun.domain.model.MovieModel

internal fun MovieListResponse.MovieListResultResponse.MovieDto.toDomain() = MovieModel(
    movieCode = movieCode,
    movieName = movieName,
    genre = genre,
    nation = nation
)