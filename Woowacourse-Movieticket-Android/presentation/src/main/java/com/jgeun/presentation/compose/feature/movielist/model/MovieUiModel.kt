package com.jgeun.presentation.compose.feature.movielist.model

import com.jgeun.domain.model.MovieModel

data class MovieUiModel(
    val code: String,
    val title: String,
    val genre: String,
    val price: Int
)

fun MovieModel.toUiModel(): MovieUiModel {
    return MovieUiModel(
        code = this.movieCode,
        title = this.movieName,
        genre = this.genre,
        price = this.price
    )
}