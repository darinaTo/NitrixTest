package com.example.nitrixsofttest.domain.entities.networkEntities

import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse(
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String,
    val title: String
)




