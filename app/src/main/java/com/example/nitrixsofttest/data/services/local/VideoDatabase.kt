package com.example.nitrixsofttest.data.services.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nitrixsofttest.domain.entities.dbEntities.VideoEntity

@Database(entities = [VideoEntity::class], version = 1)
abstract class VideoDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}