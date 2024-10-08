package com.example.nitrixsofttest.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixsofttest.domain.usecases.GetVideosFromDbUseCase
import com.example.nitrixsofttest.ui.uistate.VideoPlayerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getVideosFromDbUseCase: GetVideosFromDbUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(VideoPlayerUiState())
    val uiState = _uiState.asStateFlow()

    init {
         val id : Int = requireNotNull(savedStateHandle.get<Int>("id"))
        viewModelScope.launch {
            getVideosFromDbUseCase.execute(id).onEach {video ->
                _uiState.update { it.copy(video = video, isLoading = true) }
            }.launchIn(viewModelScope)
        }
    }
}