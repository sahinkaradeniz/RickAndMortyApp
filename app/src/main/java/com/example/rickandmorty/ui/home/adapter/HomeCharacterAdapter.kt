package com.example.rickandmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.RowCharacterHomeBinding
import com.example.rickandmorty.ui.home.HomeCharacterUiData

class HomeCharacterAdapter(private val characterClick: (Int) -> Unit) :
    RecyclerView.Adapter<HomeCharacterViewHolder>() {
    private val characterList = mutableListOf<HomeCharacterUiData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCharacterViewHolder {
        val bind = RowCharacterHomeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HomeCharacterViewHolder(::characterClick, bind)
    }

    private fun characterClick(i: Int) {
        characterClick.invoke(i)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: HomeCharacterViewHolder, position: Int) {
        holder.bind(homeCharacterUiData = characterList[position])
    }

    fun updateCharacterAdapterData(newItems: List<HomeCharacterUiData>) {
       val diffResult = DiffUtil.calculateDiff(CharacterDiffCallback(characterList, newItems))
        characterList.clear()
        characterList.addAll(newItems)
       diffResult.dispatchUpdatesTo(this)
    }

    private inner class CharacterDiffCallback(
        private val oldList: List<HomeCharacterUiData>,
        private val newList: List<HomeCharacterUiData>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }
    }
}
