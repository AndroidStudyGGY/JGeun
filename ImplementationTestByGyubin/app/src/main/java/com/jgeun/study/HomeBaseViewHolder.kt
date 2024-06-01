package com.jgeun.study

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jgeun.core.domain.model.HomeUiModel

sealed class HomeBaseViewHolder(
	binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

	abstract fun bind(item: HomeUiModel)
}