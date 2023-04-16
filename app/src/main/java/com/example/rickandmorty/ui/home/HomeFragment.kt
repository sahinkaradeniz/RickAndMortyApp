package com.example.rickandmorty.ui.home

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.core.BaseFragment
import com.example.common.extension.gone
import com.example.common.extension.visible
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentHomeBinding
import com.example.rickandmorty.ui.home.adapter.HomeCharacterAdapter
import com.example.rickandmorty.ui.home.adapter.HomeLocationAdapter
import com.example.rickandmorty.ui.home.adapter.LocationLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()
    private val locationAdapter by lazy { HomeLocationAdapter(::clickLocation) }
    private val characterAdapter by lazy { HomeCharacterAdapter(::clickCharacter) }

    private fun clickCharacter(i: Int) {
        Toast.makeText(requireContext(), i.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateFinished() {
        initAdapters()
        observeLiveData()
    }

    private fun initAdapters() {
        binding.horizontalRcv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRcv.adapter = locationAdapter.withLoadStateHeaderAndFooter(
            header = LocationLoadStateAdapter { locationAdapter.retry() },
            footer = LocationLoadStateAdapter { locationAdapter.retry() }
        )
        binding.verticalRcv.adapter=characterAdapter
        binding.verticalRcv.layoutManager=LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            viewModel.list.collectLatest {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun clickLocation(urlList: List<String>) {
        viewModel.getCharactersWithLocationIds(urlList)
    }

    private fun observeLiveData() {
        viewModel.characterList.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Success -> {
                    characterAdapter.updateCharacterAdapterData(it.data)
                    binding.shimmerFrameLayout.stopShimmer()
                }
                is HomeUiState.Error -> {
                    Log.e("Home Fragment", "Error: ${it.message}", )
                }
                is HomeUiState.Loading -> {
                    binding.shimmerFrameLayout.showShimmer(true)
                }
            }
        }
    }


}