package com.jgeun.presentation.compose.feature.movieinfo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jgeun.presentation.compose.feature.movieinfo.component.MovieInfoContent
import com.jgeun.presentation.compose.ui.component.LoadingIndicator

@Composable
internal fun MovieInfoRouter(
    viewModel: MovieInfoViewModel = hiltViewModel(),
    movieCode: String,
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    val movieInfoUiState by viewModel.movieInfoUiState.collectAsStateWithLifecycle()

    MovieInfoScreen(
        modifier = Modifier.padding(padding),
        movieInfoUiState = movieInfoUiState
    )

    LaunchedEffect(movieCode) {
        viewModel.fetchMovieInfo(movieCode)
    }
}

@Composable
internal fun MovieInfoScreen(
    modifier: Modifier = Modifier,
    movieInfoUiState: MovieInfoUiState = MovieInfoUiState.Loading,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when (movieInfoUiState) {
            is MovieInfoUiState.Loading -> LoadingIndicator()
            is MovieInfoUiState.Success -> MovieInfoContent(
                movieInfo = movieInfoUiState.movieInfo
            )
        }
    }
}
