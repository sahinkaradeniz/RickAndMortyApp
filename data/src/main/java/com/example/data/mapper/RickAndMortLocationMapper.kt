package com.example.data.mapper

import com.example.common.mapper.ListMapper
import com.example.common.mapper.Mapper
import com.example.data.dto.location.Results
import com.example.domain.dto.LocationEntity
import javax.inject.Inject

class RickAndMortLocationMapper @Inject constructor(): ListMapper<Results,LocationEntity> {
    override fun map(input: List<Results>): List<LocationEntity> {
        return input.map {
            LocationEntity(
                id = it.id,
                name = it.name,
                residents = it.residents
            )
        }
    }
}