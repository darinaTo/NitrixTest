package com.example.nitrixsofttest.di

import android.content.Context
import androidx.room.Room
import com.example.nitrixsofttest.data.impl.VideoRepositoryImpl
import com.example.nitrixsofttest.data.services.local.VideoDao
import com.example.nitrixsofttest.data.services.local.VideoDatabase
import com.example.nitrixsofttest.data.services.local.VideoLocalDataSource
import com.example.nitrixsofttest.data.services.remote.VideoRemoteDataSource
import com.example.nitrixsofttest.domain.repo.VideoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDao(appDatabase: VideoDatabase): VideoDao = appDatabase.videoDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): VideoDatabase {
        return Room.databaseBuilder(
            appContext,
            VideoDatabase::class.java,
            "video_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideVideoRepository(
        remoteDataSource: VideoRemoteDataSource,
        localDataSource: VideoLocalDataSource
    ): VideoRepository {
        return VideoRepositoryImpl(remoteDataSource, localDataSource)
    }
}
