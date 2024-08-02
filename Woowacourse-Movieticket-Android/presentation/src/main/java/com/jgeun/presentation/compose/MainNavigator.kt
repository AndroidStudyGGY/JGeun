package com.jgeun.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jgeun.presentation.compose.feature.movieinfo.navigation.navigateMovieInfo
import com.jgeun.presentation.compose.feature.movielist.navigation.navigateMovieList
import com.jgeun.presentation.compose.navigation.AppRoute

internal class MainNavigator(
	val navController: NavHostController
) {
	private val currentDestination: NavDestination?
		@Composable get() = navController
			.currentBackStackEntryAsState().value?.destination

	val startDestination: AppRoute = AppRoute.MovieList

	private fun popBackStack() {
		navController.popBackStack()
	}

	fun navigateMovieList() {
		navController.navigateMovieList()
	}

	fun navigateMovieInfo(movieCode: String) {
		navController.navigateMovieInfo(movieCode)
	}
}

@Composable
internal fun rememberMainNavigator(
	navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
	MainNavigator(navController)
}