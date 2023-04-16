package com.example.rickandmorty.ui.home.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class LocationLoadStateAdapter (private val retry: () -> Unit) : LoadStateAdapter<LocationLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: LocationLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LocationLoadStateViewHolder {
        return LocationLoadStateViewHolder.create(parent, retry)
    }
}