package com.jgeun.core.data.repository.github

import com.jgeun.core.model.result.ApiResult
import com.jgeun.core.model.GithubIssue
import com.jgeun.core.model.result.safeFlow
import com.jgeun.core.network.NetworkModule
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

	companion object {
		fun newInstance() = GitHubRepositoryImpl(
			NetworkModule.gitHubService
		)
	}
}