package com.example.nitrixsofttest.domain.usecases

import com.example.nitrixsofttest.domain.entities.uiEnitites.VideoUiEntity
import com.example.nitrixsofttest.domain.repo.VideoRepository
import com.example.nitrixsofttest.util.VideoMapper.mapToDbEntity
import com.example.nitrixsofttest.util.VideoMapper.mapToUiEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchAndSaveVideosUseCase @Inject constructor(private val repository: VideoRepository) {
    fun execute(): Flow<List<VideoUiEntity>> = flow {
        val mediaResponses = repository.getMediaFromApi()
        val videoResponses = mediaResponses.categories.flatMap { category ->
                category.videos
            }
        val videoEntities = videoResponses.mapIndexed { index, videoResponse ->
            videoResponse.mapToDbEntity(index)
        }
        repository.saveVideos(videoEntities)
        emit(videoEntities.map { it.mapToUiEntity() })
    }
}
