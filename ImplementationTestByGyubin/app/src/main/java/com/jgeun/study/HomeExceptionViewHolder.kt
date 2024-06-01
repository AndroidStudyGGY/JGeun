package com.jgeun.study

import com.jgeun.core.domain.model.HomeUiModel
import com.jgeun.study.databinding.ItemHomeExceptionBinding
import com.jgeun.study.databinding.ItemHomeGithubIssueBinding


class HomeExceptionViewHolder(
	private val binding: ItemHomeExceptionBinding
) : HomeBaseViewHolder(binding) {
	override fun bind(item: HomeUiModel) {}
}