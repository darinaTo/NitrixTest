package com.example.nitrixsofttest.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixsofttest.domain.usecases.FetchAndSaveVideosUseCase
import com.example.nitrixsofttest.ui.uistate.VideoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val fetchAndSaveVideosUseCase: FetchAndSaveVideosUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(VideoUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            loadVideos()
        }
    }

    private fun loadVideos() {
        viewModelScope.launch {
            fetchAndSaveVideosUseCase.execute().onEach { list ->
                _uiState.update { it.copy(videos = list, isLoading = false) }
            }.launchIn(viewModelScope)
        }
    }
}
