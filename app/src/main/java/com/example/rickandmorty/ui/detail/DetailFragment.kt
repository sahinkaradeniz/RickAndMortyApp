package com.example.rickandmorty.ui.detail

import androidx.fragment.app.viewModels
import com.example.rickandmorty.core.BaseFragment
import com.example.rickandmorty.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate){

    private val viewModel: DetailViewModel by viewModels()
    override fun onCreateFinished() {

    }

}