package com.jgeun.study

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.jgeun.study.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

	private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	private val viewModel by viewModels<HomeViewModel>()
	private val homeAdapter by lazy { HomeAdapter() }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(binding.root)
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}

		binding.recyclerview.apply {
			adapter = homeAdapter
			layoutManager = LinearLayoutManager(this@MainActivity)
		}
	}

	override fun onStart() {
		super.onStart()

		lifecycleScope.launch {
			viewModel.homeUiState.collectLatest {
				binding.progressbar.visibility = if(it is HomeUiState.Loading) View.VISIBLE else View.GONE

				if (it is HomeUiState.Success) {
					homeAdapter.submitList(it.homeUiModelList)
				}
			}
		}
	}
}