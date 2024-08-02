package com.jgeun.data.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    @SerialName("movieListResult")
    val movieListResult: MovieListResultResponse
) {
    @Serializable
    data class MovieListResultResponse(
        @SerialName("totCnt")
        val totalCnt: Int,
        @SerialName("movieList")
        val movieList: List<MovieDto>
    ) {
        @Serializable
        data class MovieDto(
            @SerialName("movieCd")
            val movieCode: String,
            @SerialName("movieNm")
            val movieName: String,
            @SerialName("repGenreNm")
            val genre: String,
            @SerialName("nationAlt")
            val nation: String
        )
    }
}
