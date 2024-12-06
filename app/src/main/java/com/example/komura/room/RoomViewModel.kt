package com.example.komura.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoViewModel(application: Application) : AndroidViewModel(application) {
    private val videoDao = VideoDatabase.getDatabase(application).videoDao()
    private val audioDao = VideoDatabase.getDatabase(application).AudioDao()

    val allVideos: LiveData<List<VideoEntity>> = videoDao.getAllVideos()
    val allAudio: LiveData<List<AudioEntity>> = audioDao.getAllAudio()

    fun insertAudio(audio: AudioEntity) {
        viewModelScope.launch {
            audioDao.insert(audio)
        }
    }
    fun insertVideo(video: VideoEntity) {
        viewModelScope.launch {
            videoDao.insert(video)
        }
    }
}

//class VideoViewModel(application: Application) : AndroidViewModel(application) {
//    private val videoDao = VideoDatabase.getDatabase(application).videoDao()
//
//    // Fungsi untuk memperbarui nama file video di database
//    fun updateVideoName(newName: String, videoId: Int) {
//        viewModelScope.launch {
//            videoDao.updateVideoName(newName, videoId)
//        }
//    }
//}