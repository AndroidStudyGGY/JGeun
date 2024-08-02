package com.jgeun.presentation.compose.feature.movielist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.jgeun.presentation.compose.feature.movielist.model.MovieUiModel
import com.jgeun.presentation.compose.ui.component.LoadingIndicator

@Composable
internal fun MovieListContent(
    modifier: Modifier = Modifier,
    movieList: LazyPagingItems<MovieUiModel>,
    onMovieClick: (MovieUiModel) -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit = {}
) {
    LaunchedEffect(movieList.loadState) {
        if(movieList.loadState.refresh is LoadState.Error) {
            onShowErrorSnackBar((movieList.loadState.refresh as LoadState.Error).error)
        }
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        if (movieList.loadState.refresh is LoadState.Loading) {
            LoadingIndicator()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = movieList.itemSnapshotList.items
                ) { searchResult ->
                    key(searchResult.code) {
                        SearchMovieItem(
                            modifier = Modifier,
                            movie = searchResult,
                            onMovieClick = { onMovieClick(searchResult) }
                        )
                    }
                }
            }
        }
    }
}