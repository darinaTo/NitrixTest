package com.example.nitrixsofttest.ui.activity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nitrixsofttest.ui.activity.VideoListScreen
import com.example.nitrixsofttest.ui.activity.VideoPlayerScreen
import com.example.nitrixsofttest.util.Constants.VIDEO_LIST
import com.example.nitrixsofttest.util.Constants.VIDEO_PLAYER

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = VIDEO_LIST
    ) {
        composable(VIDEO_LIST) {
            VideoListScreen(onVideoClick = { id ->
                navController.navigate("${VIDEO_PLAYER}/$id")
            })
        }
        composable(
            route = "${VIDEO_PLAYER}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType })
        ) {
            VideoPlayerScreen()
        }
    }
}

