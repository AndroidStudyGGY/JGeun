package com.jgeun.core.domain.repository

import com.jgeun.core.domain.model.GithubIssue
import com.jgeun.core.domain.model.result.ApiResult
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

	fun fetchRepoIssues(
		userName: String,
		repoName: String
	) : Flow<ApiResult<List<GithubIssue>>>
}