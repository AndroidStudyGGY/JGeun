package com.jgeun.core.data.repository.banner

import com.jgeun.core.model.result.ApiResult
import com.jgeun.core.model.Banner
import kotlinx.coroutines.flow.Flow

interface BannerRepository {

	fun fetchBannerList(): Flow<ApiResult<List<Banner>>>
}