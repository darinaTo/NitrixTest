package com.example.nitrixsofttest.data.services.remote

import com.example.nitrixsofttest.domain.entities.networkEntities.MediaResponse
import retrofit2.Response
import retrofit2.http.GET

interface VideoApi {
    @GET("fileTest/refs/heads/main/media.json")
    suspend fun getVideos(): Response<MediaResponse>
}
