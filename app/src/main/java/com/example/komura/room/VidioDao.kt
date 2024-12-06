package com.example.komura.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface VideoDao {
    @Insert
    suspend fun insert(video: VideoEntity)

    @Update
    suspend fun update(video: VideoEntity)

    @Query("SELECT * FROM video_table ORDER BY id DESC")
    fun getAllVideos(): LiveData<List<VideoEntity>>

    @Query("SELECT * FROM video_table WHERE id = :videoId LIMIT 1")
    suspend fun getVideoById(videoId: Int): VideoEntity?
}

@Dao
interface AudioDao {
    @Insert
    suspend fun insert(audio: AudioEntity)

    @Update
    suspend fun update(audio: AudioEntity)

    @Query("SELECT * FROM audio_table ORDER BY id DESC")
    fun getAllAudio(): LiveData<List<AudioEntity>>

    @Query("SELECT * FROM audio_table WHERE id = :AudioId LIMIT 1")
    suspend fun getAudioById(AudioId: Int): AudioEntity?
}