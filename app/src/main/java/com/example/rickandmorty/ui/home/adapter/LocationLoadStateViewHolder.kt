package com.example.rickandmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.RowLocationHorizontalLoadStateBinding

class LocationLoadStateViewHolder(
    private val binding:RowLocationHorizontalLoadStateBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState is LoadState.Error
        binding.errorMsg.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): LocationLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_location_horizontal_load_state, parent, false)
            val binding = RowLocationHorizontalLoadStateBinding.bind(view)
            return LocationLoadStateViewHolder(binding, retry)
        }
    }
}