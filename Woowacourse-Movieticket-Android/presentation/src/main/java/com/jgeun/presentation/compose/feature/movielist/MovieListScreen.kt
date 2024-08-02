package com.jgeun.presentation.compose.feature.movielist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.jgeun.presentation.compose.feature.movielist.component.MovieListContent
import com.jgeun.presentation.compose.feature.movielist.model.MovieUiModel

@Composable
internal fun MovieListRouter(
	viewModel: MovieListViewModel = hiltViewModel(),
	padding: PaddingValues,
	navigateToMovieInfo: (MovieUiModel) -> Unit,
	onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
	val movieList = viewModel.movieList.collectAsLazyPagingItems()

	MovieListScreen(
		modifier = Modifier
			.fillMaxSize()
			.padding(padding),
		movieList = movieList,
		navigateToMovieInfo = navigateToMovieInfo,
		onShowErrorSnackBar = onShowErrorSnackBar
	)
}

@Composable
internal fun MovieListScreen(
	modifier: Modifier = Modifier,
	movieList: LazyPagingItems<MovieUiModel>,
	navigateToMovieInfo: (MovieUiModel) -> Unit = {},
	onShowErrorSnackBar: (throwable: Throwable?) -> Unit = {},
) {
	MovieListContent(
		modifier = modifier,
		movieList = movieList,
		onMovieClick = navigateToMovieInfo,
		onShowErrorSnackBar = onShowErrorSnackBar
	)
}