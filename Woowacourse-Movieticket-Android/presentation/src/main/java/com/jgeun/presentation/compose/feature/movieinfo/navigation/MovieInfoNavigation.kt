package com.jgeun.presentation.compose.feature.movieinfo.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.jgeun.presentation.compose.feature.movieinfo.MovieInfoRouter
import com.jgeun.presentation.compose.navigation.AppRoute

fun NavController.navigateMovieInfo(movieCode: String) {
    navigate(AppRoute.MovieInfo(movieCode))
}

fun NavGraphBuilder.movieInfoNavGraph(
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit
) {
    composable<AppRoute.MovieInfo> { navBackStackEntry ->
        val movieCode = navBackStackEntry.toRoute<AppRoute.MovieInfo>().movieCode

        MovieInfoRouter(
            padding = padding,
            movieCode = movieCode,
            onShowErrorSnackBar = onShowErrorSnackBar
        )
    }
}