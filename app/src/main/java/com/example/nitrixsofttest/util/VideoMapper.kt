package com.example.nitrixsofttest.util

import com.example.nitrixsofttest.domain.entities.dbEntities.VideoEntity
import com.example.nitrixsofttest.domain.entities.networkEntities.VideoResponse
import com.example.nitrixsofttest.domain.entities.uiEnitites.VideoUiEntity

object VideoMapper {
    fun VideoResponse.mapToDbEntity(id: Int): VideoEntity {
        return VideoEntity(
            id = id,
            description = this.description,
            source = this.sources.firstOrNull() ?: "",
            subtitle = this.subtitle,
            thumb = this.thumb,
            title = this.title
        )
    }

    fun List<VideoEntity>.mapToUiEntity(): List<VideoUiEntity> {
        return this.map { videoEntity ->
            VideoUiEntity(
                id = videoEntity.id,
                description = videoEntity.description,
                source = videoEntity.source,
                subtitle = videoEntity.subtitle,
                thumb = videoEntity.thumb,
                title = videoEntity.title
            )
        }
    }


    fun mapToItem(videoResponse: VideoResponse, id: Int): VideoUiEntity {
        return VideoUiEntity(
            id = id,
            description = videoResponse.description,
            source = videoResponse.sources.firstOrNull() ?: "",
            subtitle = videoResponse.subtitle,
            thumb = videoResponse.thumb,
            title = videoResponse.title
        )
    }
}
