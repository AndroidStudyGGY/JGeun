package com.jgeun.study

import com.bumptech.glide.Glide
import com.jgeun.core.domain.model.HomeUiModel
import com.jgeun.study.databinding.ItemHomeBannerBinding
import com.jgeun.study.databinding.ItemHomeGithubIssueBinding

class HomeBannerViewHolder(
	private val binding: ItemHomeBannerBinding
) : HomeBaseViewHolder(binding) {

	override fun bind(item: HomeUiModel) {
		(item as? HomeUiModel.Banner)?.let {
			Glide.with(itemView)
				.load(it.bannerUrl)
				.into(binding.banner)
		}
	}
}