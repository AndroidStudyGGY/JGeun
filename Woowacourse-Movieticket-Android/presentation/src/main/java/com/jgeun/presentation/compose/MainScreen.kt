package com.jgeun.presentation.compose

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.jgeun.presentation.R
import kotlinx.coroutines.launch
import java.net.UnknownHostException

@Composable
internal fun MainScreen(
	navigator: MainNavigator = rememberMainNavigator()
) {
	val snackBarHostState = remember { SnackbarHostState() }

	val coroutineScope = rememberCoroutineScope()
	val localContextResource = LocalContext.current.resources
	val onShowErrorSnackBar: (throwable: Throwable?) -> Unit = { throwable ->
		coroutineScope.launch {
			snackBarHostState.showSnackbar(
				when(throwable) {
					is UnknownHostException -> localContextResource.getString(R.string.error_message_network)
					else -> localContextResource.getString(R.string.error_message_unknown)
				}
			)
		}
	}

	MainScreenContent(
		navigator = navigator,
		onShowErrorSnackBar = onShowErrorSnackBar,
		snackBarHostState = snackBarHostState
	)
}

@Composable
private fun MainScreenContent(
	modifier: Modifier = Modifier,
	navigator: MainNavigator,
	onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
	snackBarHostState: SnackbarHostState
) {
	Scaffold(
		modifier = modifier,
		content = { padding ->
			AppNavHost(
				navigator = navigator,
				padding = padding,
				onShowErrorSnackBar = onShowErrorSnackBar
			)
		},
		snackbarHost = { SnackbarHost(snackBarHostState) }
	)
}