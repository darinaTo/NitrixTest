package com.example.nitrixsofttest.data.services.remote

import com.example.nitrixsofttest.domain.entities.networkEntities.MediaResponse
import java.io.IOException
import javax.inject.Inject

class VideoRemoteDataSource @Inject constructor(
    private val videoApi: VideoApi
) {
    suspend fun getMediasFromApi(): Result<MediaResponse> {
        return runCatching {
            val response = videoApi.getVideos()
            if (response.isSuccessful) {
                response.body() ?: throw IOException("No data received.")
            } else {
                throw IOException("Request failed with code ${response.code()}")
            }
        }.map {
            it
        }
    }
}
