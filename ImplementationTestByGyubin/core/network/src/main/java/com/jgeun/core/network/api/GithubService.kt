package com.jgeun.core.network.api

import com.jgeun.core.network.model.GithubRepoIssueResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

	@GET("repos/{userName}/{repoName}/issues")
	suspend fun fetchRepoIssues(
		@Path("userName") userName: String,
		@Path("repoName") repoName: String
	) : List<GithubRepoIssueResponse>
}