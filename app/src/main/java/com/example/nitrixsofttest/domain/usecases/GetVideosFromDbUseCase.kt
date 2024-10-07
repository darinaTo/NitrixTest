package com.example.nitrixsofttest.domain.usecases

import com.example.nitrixsofttest.domain.entities.dbEntities.VideoEntity
import com.example.nitrixsofttest.domain.repo.VideoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideosFromDbUseCase @Inject constructor(
    private val repository: VideoRepository
) {
    suspend fun execute(): Flow<List<VideoEntity>> {
        return repository.getVideosFromDb()
    }
}
