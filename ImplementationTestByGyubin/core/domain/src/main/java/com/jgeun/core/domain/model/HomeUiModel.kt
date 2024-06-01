package com.jgeun.core.domain.model

import com.jgeun.core.model.Banner
import com.jgeun.core.model.GithubIssue

sealed interface HomeUiModel {
	data class GithubIssue(
		val id: Long,
		val title: String,
		val number: Int
	) : HomeUiModel

	data class Banner(
		val bannerUrl: String,
	) : HomeUiModel
}

fun GithubIssue.toHomeUiModel() = HomeUiModel.GithubIssue(
	id = this.id,
	title = this.title,
	number = this.number
)

fun Banner.toHomeUiModel() = HomeUiModel.Banner(
	bannerUrl = bannerUrl
)