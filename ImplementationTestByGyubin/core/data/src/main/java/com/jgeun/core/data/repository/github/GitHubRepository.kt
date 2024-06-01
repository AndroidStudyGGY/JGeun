package com.jgeun.core.data.repository.github

import com.jgeun.core.model.result.ApiResult
import com.jgeun.core.model.GithubIssue
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

	fun fetchRepoIssues(
		userName: String,
		repoName: String
	) : Flow<ApiResult<List<GithubIssue>>>
}