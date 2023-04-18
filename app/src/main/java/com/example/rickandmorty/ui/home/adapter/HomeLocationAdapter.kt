package com.example.rickandmorty.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.LocationEntity
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.RowLocationHorizontalBinding

class HomeLocationAdapter(private val locationClick: (residents: List<String>) -> Unit) :
    PagingDataAdapter<LocationEntity, HomeLocationViewHolder>(LocationComparator) {
    private var oldSelectedPosition = 0
    override fun onBindViewHolder(
        holder: HomeLocationViewHolder,
        position: Int
    ) {
        val pos = holder.bindingAdapterPosition
        getItem(pos)?.let { location ->

            if (oldSelectedPosition == pos) {
                location.isSelected = true
                locationClick.invoke(location.residents)
            }

            if (location.isSelected) {
                holder.itemView.setBackgroundResource(R.drawable.row_location_selected_bg)
            } else {
                holder.itemView.setBackgroundResource(R.drawable.row_location_bg)
            }

            holder.bind(location)

            holder.itemView.setOnClickListener {
                if (oldSelectedPosition != pos) {
                    getItem(oldSelectedPosition)?.isSelected = false
                    notifyItemChanged(oldSelectedPosition)
                }
                location.isSelected = true
                notifyItemChanged(pos)
                locationClick.invoke(location.residents)
                oldSelectedPosition = pos
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeLocationViewHolder {
        val binding =
            RowLocationHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeLocationViewHolder(binding)
    }

    object LocationComparator : DiffUtil.ItemCallback<LocationEntity>() {
        override fun areItemsTheSame(oldItem: LocationEntity, newItem: LocationEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LocationEntity, newItem: LocationEntity): Boolean {
            return oldItem == newItem
        }
    }

}

