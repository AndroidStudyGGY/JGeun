package com.jgeun.study

import com.jgeun.core.domain.model.HomeUiModel
import com.jgeun.study.databinding.ItemHomeGithubIssueBinding


class HomeGitHubIssueViewHolder(
	private val binding: ItemHomeGithubIssueBinding
) : HomeBaseViewHolder(binding) {
	override fun bind(item: HomeUiModel) {
		(item as? HomeUiModel.GithubIssue)?.let {
			binding.githubIssueTitle.text = it.title
			binding.githubIssueNumber.text = "#${it.number}"
		}
	}
}