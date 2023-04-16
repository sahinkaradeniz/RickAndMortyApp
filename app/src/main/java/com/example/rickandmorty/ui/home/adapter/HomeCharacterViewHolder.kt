package com.example.rickandmorty.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.RowCharacterHomeBinding
import com.example.rickandmorty.ui.home.HomeCharacterUiData

class HomeCharacterViewHolder(
    private val characterClick: (Int) -> Unit,
    private val binding: RowCharacterHomeBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(homeCharacterUiData: HomeCharacterUiData) {
        binding.characterComponent.setCharacterData(homeCharacterUiData)
        binding.characterComponent.characterItemClickListener {
            characterClick.invoke(homeCharacterUiData.id)
        }
    }
}