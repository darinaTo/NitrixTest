package com.example.nitrixsofttest.ui.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.nitrixsofttest.ui.viewmodels.VideoViewModel
import com.example.nitrixsofttest.util.generateVideoThumbnailUrl

@Composable
fun VideoListScreen(
    viewModel: VideoViewModel = hiltViewModel(),
    onVideoClick: (id : Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val videos = uiState.videos
    if (uiState.isLoading) {
        LazyColumn(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(videos) { video ->
                VideoItem(
                    id = video.id,
                    image = generateVideoThumbnailUrl(video.source, video.thumb),
                    description = video.description,
                    title = video.title,
                    onVideoClick = onVideoClick
                )
            }
        }
    } else {
        ProgressBar()
    }
}


@Composable
fun VideoItem(
    modifier: Modifier = Modifier,
    image: String,
    description: String,
    title: String,
    onVideoClick: (id: Int) -> Unit,
    id: Int
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(12.dp)
    ) {
        Text(
            text = title,
            overflow = TextOverflow.Ellipsis
        )
        AsyncImage(
            modifier = Modifier
                .width(400.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable { onVideoClick(id) },
            model = image,
            contentScale = ContentScale.Crop,
            contentDescription = "prev"
        )
        Text(
            text = description,
            overflow = TextOverflow.Ellipsis
        )
    }
}