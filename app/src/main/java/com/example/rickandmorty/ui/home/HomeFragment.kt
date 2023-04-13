package com.example.rickandmorty.ui.home

import androidx.fragment.app.viewModels
import com.example.common.core.BaseFragment
import com.example.rickandmorty.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateFinished() {

    }

}