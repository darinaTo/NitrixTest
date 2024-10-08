package com.example.nitrixsofttest.domain.usecases

import com.example.nitrixsofttest.domain.entities.uiEnitites.VideoUiEntity
import com.example.nitrixsofttest.domain.repo.VideoRepository
import com.example.nitrixsofttest.util.VideoMapper.mapToUiEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetVideosFromDbUseCase @Inject constructor(
    private val repository: VideoRepository
) {
    suspend fun execute(id : Int): Flow<VideoUiEntity> {
        return repository.getVideoById(id).map { it.mapToUiEntity() }
    }
}
