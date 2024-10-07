package com.example.nitrixsofttest.domain.entities.networkEntities

import kotlinx.serialization.Serializable

@Serializable
data class MediaResponse(
    val categories: List<CategoryResponse>
)