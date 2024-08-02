package com.jgeun.presentation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.jgeun.presentation.compose.ui.theme.MovieTicketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivityByCompose : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		WindowCompat.setDecorFitsSystemWindows(window, false)

		setContent {
			val navigator: MainNavigator = rememberMainNavigator()

			MovieTicketTheme {
				MainScreen(
					navigator = navigator
				)
			}
		}
	}
}