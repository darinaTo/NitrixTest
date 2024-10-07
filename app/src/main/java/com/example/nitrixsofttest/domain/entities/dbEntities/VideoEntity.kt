package com.example.nitrixsofttest.domain.entities.dbEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class VideoEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val description: String,
    val source: String,
    val subtitle: String,
    val thumb: String,
    val title: String
)
