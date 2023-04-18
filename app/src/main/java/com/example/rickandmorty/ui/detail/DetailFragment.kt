package com.example.rickandmorty.ui.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.common.extension.downloadFromUrl
import com.example.domain.entity.CharacterEntity
import com.example.rickandmorty.core.BaseFragment
import com.example.rickandmorty.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate){

    private val viewModel: DetailViewModel by viewModels()
    private val args:DetailFragmentArgs by navArgs()
    override fun onCreateFinished() {
        observeLiveData()
        val id =args.id
        viewModel.getRickAndMortyCharacter(id)
    }

    override fun initListener() {
        binding.backButtonDetail.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeLiveData(){
        viewModel.detailUiState.observe(viewLifecycleOwner){
            when(it){
                is DetailUiState.Loading ->{
                }
                is DetailUiState.Error ->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is DetailUiState.Success ->{
                    it.data?.let{ detailData->
                        setData(detailData)
                    }
                }
            }
        }
    }
    private fun setData(characterEntity: CharacterEntity){
        binding.apply {
            characterNameText.text=characterEntity.name
            detailCharacterImage.downloadFromUrl(characterEntity.image)
            createdTextDetail2.text=characterEntity.created
            episodesTextDetail2.text=characterEntity.episodes
            genderTextDetail2.text=characterEntity.gender
            originTextDetail2.text=characterEntity.origin
            locationTextDetail2.text=characterEntity.location
            statusTextDetail2.text=characterEntity.status
            specyTextDetail2.text=characterEntity.species
        }
    }

}