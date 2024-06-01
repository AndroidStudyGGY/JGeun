package com.jgeun.core.data.repository

import com.jgeun.core.domain.model.GithubIssue
import com.jgeun.core.domain.model.result.ApiResult
import com.jgeun.core.domain.model.result.safeFlow
import com.jgeun.core.domain.repository.GitHubRepository
import com.jgeun.core.network.api.GithubService
import kotlinx.coroutines.flow.Flow

class GitHubRepositoryImpl private constructor(
	private val githubService: GithubService
) : GitHubRepository {
	override fun fetchRepoIssues(
		userName: String,
		repoName: String
	): Flow<ApiResult<List<GithubIssue>>> = safeFlow {
		githubService.fetchRepoIssues(
			userName = userName,
			repoName = repoName
		).map {
			it.toDomain()
		}
	}
}