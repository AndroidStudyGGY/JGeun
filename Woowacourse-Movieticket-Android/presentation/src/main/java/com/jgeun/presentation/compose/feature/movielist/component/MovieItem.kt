package com.jgeun.presentation.compose.feature.movielist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jgeun.presentation.compose.feature.movielist.model.MovieUiModel

@Composable
internal fun SearchMovieItem(
    modifier: Modifier = Modifier,
    movie: MovieUiModel,
    onMovieClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onMovieClick() }
    ) {
        Text(
            text = "영화 이름: ${movie.title}",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "장르 ${movie.genre}",
                fontSize = 15.sp
            )

            Text(
                text = "가격: ${movie.price}",
                fontSize = 15.sp
            )
        }

    }
}

@Preview
@Composable
private fun SearchMovieItemPreview() {
    SearchMovieItem(
        movie = MovieUiModel(
            code = "a",
            title = "name",
            genre = "장르",
            price = 1000000
        )
    )
}