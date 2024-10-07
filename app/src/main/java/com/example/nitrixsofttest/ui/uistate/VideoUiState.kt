package com.example.nitrixsofttest.ui.uistate

import com.example.nitrixsofttest.domain.entities.uiEnitites.VideoUiEntity

data class VideoUiState(
    val videos : List<VideoUiEntity> = emptyList(),
   val isLoading : Boolean = false
)
