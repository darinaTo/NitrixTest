package com.example.nitrixsofttest.ui.activity

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

@Composable
    fun VideoPlayerScreen(
    context : Context,
    path: String,
    ) {
        val mediaSource = remember(path) {
            MediaItem.fromUri(path)
        }
        val exoPlayer = ExoPlayer.Builder(context).build()

        LaunchedEffect(mediaSource) {
            exoPlayer.setMediaItem(mediaSource)
            exoPlayer.prepare()
        }

        DisposableEffect(Unit) {
            onDispose {
                exoPlayer.release()
            }
        }

        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
