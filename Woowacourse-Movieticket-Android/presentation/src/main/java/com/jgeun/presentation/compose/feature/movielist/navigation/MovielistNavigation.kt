package com.jgeun.presentation.compose.feature.movielist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jgeun.presentation.compose.feature.movielist.MovieListRouter
import com.jgeun.presentation.compose.feature.movielist.model.MovieUiModel
import com.jgeun.presentation.compose.navigation.AppRoute

fun NavController.navigateMovieList() {
	navigate(AppRoute.MovieList)
}

fun NavGraphBuilder.movieListNavGraph(
	padding: PaddingValues,
	navigateToMovieInfo: (MovieUiModel) -> Unit,
	onShowErrorSnackBar: (throwable: Throwable?) -> Unit
) {
	composable<AppRoute.MovieList> {
		MovieListRouter(
			padding = padding,
			onShowErrorSnackBar = onShowErrorSnackBar,
			navigateToMovieInfo = navigateToMovieInfo
		)
	}
}