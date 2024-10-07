package com.example.nitrixsofttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nitrixsofttest.ui.activity.VideoListScreen
import com.example.nitrixsofttest.ui.theme.NitrixSoftTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NitrixSoftTestTheme {
                VideoListScreen()
            }
        }
    }
}

