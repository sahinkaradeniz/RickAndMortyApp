package com.example.common.mapper

interface Mapper<I,O>{
    fun map(input:I):O
}