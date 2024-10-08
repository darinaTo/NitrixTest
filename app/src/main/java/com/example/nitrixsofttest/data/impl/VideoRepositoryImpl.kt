package com.example.nitrixsofttest.data.impl

import com.example.nitrixsofttest.data.services.local.VideoLocalDataSource
import com.example.nitrixsofttest.data.services.remote.VideoRemoteDataSource
import com.example.nitrixsofttest.domain.entities.dbEntities.VideoEntity
import com.example.nitrixsofttest.domain.entities.networkEntities.MediaResponse
import com.example.nitrixsofttest.domain.repo.VideoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val remoteDataSource: VideoRemoteDataSource,
    private val localDataSource: VideoLocalDataSource
) : VideoRepository {

    override suspend fun getMediaFromApi(): MediaResponse {
        return remoteDataSource.getMediasFromApi().getOrDefault(MediaResponse(emptyList()))
    }

    override suspend fun getVideoById(id : Int): Flow<VideoEntity> {
        return localDataSource.getVideoById(id)
    }

    override suspend fun saveVideos(videos: List<VideoEntity>) {
        localDataSource.saveVideos(videos)
    }
}
