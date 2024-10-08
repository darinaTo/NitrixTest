package com.example.nitrixsofttest.domain.repo

import com.example.nitrixsofttest.domain.entities.dbEntities.VideoEntity
import com.example.nitrixsofttest.domain.entities.networkEntities.MediaResponse
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun getMediaFromApi(): MediaResponse
    suspend fun getVideoById(id : Int): Flow<VideoEntity>
    suspend fun saveVideos(videos: List<VideoEntity>)
}
