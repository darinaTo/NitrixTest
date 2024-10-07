package com.example.nitrixsofttest.ui.activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.nitrixsofttest.ui.viewmodels.VideoViewModel

@Composable
fun VideoListScreen(viewModel: VideoViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val videos = uiState.videos
    val context = LocalContext.current
    if (!uiState.isLoading) {
        LazyRow (modifier = Modifier.fillMaxSize()){
            items(videos) { video ->
                VideoItem(video.thumb)
            }
        }
    } else {
        Box(Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
           CircularProgressIndicator()
        }
    }
}


@Composable
fun VideoItem(
    image : String,
) {

}