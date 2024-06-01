package com.jgeun.core.data.repository.banner

import com.jgeun.core.model.result.ApiResult
import com.jgeun.core.model.Banner
import kotlinx.coroutines.flow.flow

class BannerRepositoryImpl private constructor() : BannerRepository {

	override fun fetchBannerList() = flow {
		emit (
			ApiResult.Success(
			listOf(
				Banner(3, "https://picsum.photos/id/103/2592/1936")
			)
		))
	}
	companion object {
		fun newInstance() = BannerRepositoryImpl(
		)
	}
}