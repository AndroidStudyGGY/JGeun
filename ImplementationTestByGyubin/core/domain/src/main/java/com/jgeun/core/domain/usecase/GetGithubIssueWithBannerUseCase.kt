package com.jgeun.core.domain.usecase

import com.jgeun.core.data.repository.banner.BannerRepository
import com.jgeun.core.data.repository.banner.BannerRepositoryImpl
import com.jgeun.core.data.repository.github.GitHubRepository
import com.jgeun.core.data.repository.github.GitHubRepositoryImpl
import com.jgeun.core.domain.model.HomeUiModel
import com.jgeun.core.domain.model.toHomeUiModel
import com.jgeun.core.model.Banner
import com.jgeun.core.model.result.ApiResult
import com.jgeun.core.model.result.zip
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip

class GetGithubIssueWithBannerUseCase private constructor(
	private val gitHubRepository: GitHubRepository,
	private val bannerRepository: BannerRepository
) {
	operator fun invoke(
		userName: String,
		repoName: String
	): Flow<ApiResult<List<HomeUiModel>>> = gitHubRepository.fetchRepoIssues(userName = userName, repoName = repoName).zip(
		bannerRepository.fetchBannerList()
	) { githubIssueResult, bannerResult ->
		githubIssueResult.zip(bannerResult) { githubIssueList, bannerList ->
			val homeUiModelList: List<HomeUiModel> = githubIssueList.map { it.toHomeUiModel() }.toMutableList()
			combineWithBannerList(homeUiModelList, bannerList)
		}
	}

	private fun combineWithBannerList(homeUiModelList: List<HomeUiModel>, bannerList: List<Banner>): List<HomeUiModel> {
		// 비어 있는 경우
		if (bannerList.isEmpty()) return homeUiModelList

		val list = homeUiModelList.toMutableList()

		// 뒤에서 부터 넣어야 온전한 Index 위치에 넣을 수 있음
		val bannerListByDesc = bannerList.sortedByDescending { it.inputIndex }

		/**
		 * 배열의 시작은 0 이므로 원하는 위치 - 1
		 * 배열의 사이즈보다 위치값이 클 경우 맨 뒤에 입력
		 */
		bannerListByDesc.forEach {
			val index = it.inputIndex - 1
			if (homeUiModelList.size < index) {
				list.add(it.toHomeUiModel())
			}
			else {
				list.add(index, it.toHomeUiModel())
			}
		}

		return list
	}

	companion object {
		fun newInstance() = GetGithubIssueWithBannerUseCase(
			gitHubRepository = GitHubRepositoryImpl.newInstance(),
			bannerRepository = BannerRepositoryImpl.newInstance()
		)
	}
}