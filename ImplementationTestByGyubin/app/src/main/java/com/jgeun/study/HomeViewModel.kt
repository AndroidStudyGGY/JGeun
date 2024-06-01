package com.jgeun.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeun.core.domain.usecase.GetGithubIssueWithBannerUseCase
import com.jgeun.core.model.result.ApiResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModel(
	private val getGitHubIssueWithBanner: GetGithubIssueWithBannerUseCase = GetGithubIssueWithBannerUseCase.newInstance()
) : ViewModel() {

	private val userNameFlow = MutableStateFlow("JakeWharton")
	private val repoNameFlow = MutableStateFlow("hugo")

	val homeUiState = userNameFlow.combine(repoNameFlow) { userName, repoName ->
		Pair(userName, repoName)
	}.flatMapLatest {
		getGitHubIssueWithBanner(
			userName = it.first,
			repoName = it.second
		).map {
			when (it) {
				is ApiResult.Success -> HomeUiState.Success(it.data)
				is ApiResult.Error -> HomeUiState.Failure(it.exception)
			}
		}
	}.stateIn(
		scope = viewModelScope,
		started = SharingStarted.WhileSubscribed(5000L),
		initialValue = HomeUiState.Loading
	)
}