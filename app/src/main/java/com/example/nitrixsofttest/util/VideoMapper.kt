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

    fun VideoEntity.mapToUiEntity(): VideoUiEntity {
        return VideoUiEntity(
                id = this.id,
                description = this.description,
                source = this.source,
                subtitle = this.subtitle,
                thumb = this.thumb,
                title = this.title
            )
        }
    }

