package com.example.nitrixsofttest.domain.entities.networkEntities

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val name: String,
    val videos: List<VideoResponse>
)
