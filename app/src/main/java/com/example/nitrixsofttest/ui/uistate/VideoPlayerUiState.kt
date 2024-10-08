package com.example.nitrixsofttest.ui.uistate

import com.example.nitrixsofttest.domain.entities.uiEnitites.VideoUiEntity

data class VideoPlayerUiState(
    val video: VideoUiEntity = VideoUiEntity(),
    val isLoading: Boolean = false
)