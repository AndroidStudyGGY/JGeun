package com.jgeun.presentation.compose.feature.movieinfo

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.jgeun.domain.model.MovieInfoModel

@Stable
sealed interface MovieInfoUiState {

    @Immutable
    data object Loading : MovieInfoUiState

    @Immutable
    data class Success(val movieInfo: MovieInfoModel) : MovieInfoUiState
}
