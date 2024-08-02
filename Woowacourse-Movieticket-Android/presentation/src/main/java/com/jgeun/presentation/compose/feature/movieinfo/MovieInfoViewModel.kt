package com.jgeun.presentation.compose.feature.movieinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeun.domain.usecase.GetMovieInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieInfoViewModel @Inject constructor(
    private val getMovieInfoUseCase: GetMovieInfoUseCase
) : ViewModel() {

    private val _movieInfoUiState =
        MutableStateFlow<MovieInfoUiState>(MovieInfoUiState.Loading)
    val movieInfoUiState = _movieInfoUiState.asStateFlow()

    fun fetchMovieInfo(movieCode: String) {
        viewModelScope.launch {
            getMovieInfoUseCase(movieCode).collectLatest {
                _movieInfoUiState.value = MovieInfoUiState.Success(it)
            }
        }
    }
}