package com.jgeun.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.jgeun.presentation.compose.feature.movieinfo.navigation.movieInfoNavGraph
import com.jgeun.presentation.compose.feature.movielist.navigation.movieListNavGraph

@Composable
internal fun AppNavHost(
	modifier: Modifier = Modifier,
	navigator: MainNavigator,
	padding: PaddingValues,
	onShowErrorSnackBar: (throwable: Throwable?) -> Unit
) {
	Box(
		modifier = modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.surface)
	) {
		NavHost(
			navController = navigator.navController,
			startDestination = navigator.startDestination
		) {
			movieListNavGraph(
				padding = padding,
				navigateToMovieInfo = { navigator.navigateMovieInfo(it.code) },
				onShowErrorSnackBar = onShowErrorSnackBar
			)

			movieInfoNavGraph(
				padding = padding,
				onShowErrorSnackBar = onShowErrorSnackBar
			)
		}
	}
}