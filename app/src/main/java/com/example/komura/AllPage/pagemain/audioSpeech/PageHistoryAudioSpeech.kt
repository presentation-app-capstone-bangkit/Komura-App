package com.example.komura.AllPage.pagemain.audioSpeech

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.komura.AllPage.pagemain.vidioSpeech.componentPageVidioSpeech.CardVidio
import com.example.komura.R
import com.example.komura.room.VideoViewModel

@Composable
fun PageAudioSpeech() {
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var currentlyPlayingPath by remember { mutableStateOf<String?>(null) }
    var isPlaying by remember { mutableStateOf(false) }

    val videoViewModel: VideoViewModel = viewModel()
    val AudioList by videoViewModel.allAudio.observeAsState(initial = emptyList())

    if (AudioList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.chat),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
                    .width(230.dp)
            )
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                text = "Get Started",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Click on the button at the bottom to start\na new Audio speech analysis",
                textAlign = TextAlign.Center
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = AudioList) {
                Spacer(modifier = Modifier.padding(5.dp))
                CardAudio(
                    audio = it,
                    isPlaying = currentlyPlayingPath == it.filePath && isPlaying,
                    onPlayPauseClick = { filePath ->
                        if (currentlyPlayingPath == filePath && isPlaying) {
                            mediaPlayer?.pause()
                            isPlaying = false
                        } else {
                            mediaPlayer?.stop()
                            mediaPlayer?.release()
                            mediaPlayer = MediaPlayer().apply {
                                setDataSource(filePath)
                                prepare()
                                start()
                                setOnCompletionListener {
                                    currentlyPlayingPath = null
                                    isPlaying = false
                                }
                            }
                            currentlyPlayingPath = filePath
                            isPlaying = true
                        }
                    }
                )
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PageAudioSpeechPrev() {
    PageAudioSpeech()
}








