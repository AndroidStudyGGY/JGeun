package com.jgeun.presentation.compose.feature.movieinfo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.jgeun.domain.model.MovieInfoModel

@Composable
internal fun MovieInfoContent(
    modifier: Modifier = Modifier,
    movieInfo: MovieInfoModel,
) {
    Column(modifier) {
        Text(
            text = movieInfo.code,
            fontSize = 10.sp
        )
        Text(
            text = movieInfo.title,
            fontSize = 20.sp
        )
        Text(
            text = movieInfo.showTm,
            fontSize = 15.sp
        )

        Text(
            text = movieInfo.prdtYear,
            fontSize = 15.sp
        )
    }
}
