package com.jgeun.presentation.compose.feature.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.jgeun.domain.model.MovieModel
import com.jgeun.domain.usecase.GetMovieListUseCase
import com.jgeun.presentation.compose.feature.movielist.model.MovieUiModel
import com.jgeun.presentation.compose.feature.movielist.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    val movieList: StateFlow<PagingData<MovieUiModel>> = getMovieListUseCase()
        .map { pagingData ->
            pagingData.map(MovieModel::toUiModel)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = PagingData.empty()
        )
}