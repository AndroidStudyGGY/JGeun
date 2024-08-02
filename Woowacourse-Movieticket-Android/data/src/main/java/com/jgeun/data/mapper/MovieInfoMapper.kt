package com.jgeun.data.mapper

import com.jgeun.data.network.model.response.MovieInfoResultResponse
import com.jgeun.domain.model.MovieInfoModel

internal fun MovieInfoResultResponse.MovieInfoResponse.MovieInfoDto.toDomain() = MovieInfoModel(
    code = this.movieCode,
    title = this.movieName,
    prdtYear = this.prdtYear,
    showTm = this.showTm
)