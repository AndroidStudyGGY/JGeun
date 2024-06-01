package com.jgeun.study

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jgeun.core.domain.model.HomeUiModel

class HomeAdapter : ListAdapter<HomeUiModel, HomeBaseViewHolder>(DiffUtilCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBaseViewHolder {
		return when (viewType) {
			GITHUB_ISSUE -> HomeGitHubIssueViewHolder(getViewDataBinding(parent, R.layout.item_home_github_issue))
			BANNER -> HomeBannerViewHolder(getViewDataBinding(parent, R.layout.item_home_banner))
			else -> HomeExceptionViewHolder(getViewDataBinding(parent, R.layout.item_home_exception))
		}
	}

	override fun onBindViewHolder(holder: HomeBaseViewHolder, position: Int) {
		holder.bind(currentList[position])
	}

	override fun getItemViewType(position: Int): Int {
		return when(currentList[position]) {
			is HomeUiModel.GithubIssue -> GITHUB_ISSUE
			is HomeUiModel.Banner -> BANNER
		}
	}

	private fun <T: ViewDataBinding> getViewDataBinding(parent: ViewGroup, layoutRes: Int) : T {
		return DataBindingUtil.inflate(
			LayoutInflater.from(parent.context),
			layoutRes,
			parent,
			false
		)
	}

	companion object {
		private const val GITHUB_ISSUE = 0
		private const val BANNER = 1
	}

	internal class DiffUtilCallback : DiffUtil.ItemCallback<HomeUiModel>() {
		override fun areItemsTheSame(
			oldItem: HomeUiModel,
			newItem: HomeUiModel
		): Boolean {
			return oldItem == newItem
		}

		override fun areContentsTheSame(
			oldItem: HomeUiModel,
			newItem: HomeUiModel
		): Boolean {
			return oldItem == newItem
		}
	}
}