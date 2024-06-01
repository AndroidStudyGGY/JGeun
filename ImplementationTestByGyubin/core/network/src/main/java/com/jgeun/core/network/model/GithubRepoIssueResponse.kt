package com.jgeun.core.network.model

import com.jgeun.core.model.GithubIssue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepoIssueResponse(
	@SerialName("id")
	val id: Long,
	@SerialName("number")
	val number: Int,
	@SerialName("title")
	val title: String
) {
	fun toDomain() = com.jgeun.core.model.GithubIssue(
		id = id,
		number = number,
		title = title
	)
}