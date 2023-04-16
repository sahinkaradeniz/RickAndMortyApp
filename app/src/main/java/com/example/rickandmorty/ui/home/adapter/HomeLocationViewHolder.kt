package com.example.rickandmorty.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.LocationEntity
import com.example.rickandmorty.databinding.RowLocationHorizontalBinding

class HomeLocationViewHolder(private val binding: RowLocationHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(locationEntity: LocationEntity) {
        binding.textView2.text = locationEntity.name
    }
}