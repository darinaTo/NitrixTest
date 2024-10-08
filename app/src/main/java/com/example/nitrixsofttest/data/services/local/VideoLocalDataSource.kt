package com.example.nitrixsofttest.data.services.local

import com.example.nitrixsofttest.domain.entities.dbEntities.VideoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VideoLocalDataSource @Inject constructor(
    private val videoDao: VideoDao
) {
    suspend fun getVideoById(id : Int): Flow<VideoEntity> =
        withContext(Dispatchers.IO) {
            videoDao.getVideoByID(id)
        }


    suspend fun saveVideos(videos: List<VideoEntity>) =
        withContext(Dispatchers.IO) {
            videoDao.insertVideos(videos)
        }
}
