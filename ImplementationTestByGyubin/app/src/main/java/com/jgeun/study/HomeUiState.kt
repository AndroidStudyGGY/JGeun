package com.jgeun.study

import com.jgeun.core.domain.model.HomeUiModel

sealed interface HomeUiState {

	data object Loading : HomeUiState

	data class Success(
		val homeUiModelList: List<HomeUiModel>
	) : HomeUiState

	data class Failure(
		val exception: Exception
	) : HomeUiState
}