package com.example.myrickymortyapplication.domain.model

import com.example.myrickymortyapplication.data.resource.remote.dto.Location
import com.example.myrickymortyapplication.data.resource.remote.dto.LocationX
import com.example.myrickymortyapplication.data.resource.remote.dto.Origin
import com.example.myrickymortyapplication.data.resource.remote.dto.OriginX

data class Character(

    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: OriginX,
    val location: LocationX,
    val image: String
)
