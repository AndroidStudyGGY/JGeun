package com.jgeun.presentation.compose.navigation

import kotlinx.serialization.Serializable


sealed interface AppRoute {

	@Serializable
	data object MovieList : AppRoute

	@Serializable
	data class MovieInfo(val movieCode: String) : AppRoute

	@Serializable
	data object TicketingResult : AppRoute
}