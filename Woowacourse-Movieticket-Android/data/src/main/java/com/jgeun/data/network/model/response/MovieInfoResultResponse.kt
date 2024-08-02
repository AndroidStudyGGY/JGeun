package com.jgeun.data.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieInfoResultResponse(
    @SerialName("movieInfoResult")
    val movieInfoResult: MovieInfoResponse
) {
    @Serializable
    data class MovieInfoResponse(
        @SerialName("movieInfo")
        val movieInfoDto: MovieInfoDto
    ) {
        @Serializable
        data class MovieInfoDto(
            @SerialName("movieCd")
            val movieCode: String,
            @SerialName("movieNm")
            val movieName: String,
            @SerialName("prdtYear")
            val prdtYear: String,
            @SerialName("showTm")
            val showTm: String,
        )
    }
}
