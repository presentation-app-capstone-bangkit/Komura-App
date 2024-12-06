package com.example.komura.AllPage.pagemain.audioSpeech

import android.media.MediaPlayer
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.komura.R
import com.example.komura.room.AudioEntity

@Composable
fun CardAudio(
    audio: AudioEntity,
    isPlaying: Boolean,
    onPlayPauseClick: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        content = {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            val (icon, text, endIcon) = createRefs()
                            Box(
                                modifier = Modifier
                                    .clickable { onPlayPauseClick(audio.filePath) }
                                    .size(60.dp)
                                    .background(
//                                        color = if (isPlaying) Color(0xff00a6ff) else Color.Gray,
                                        color = Color(0xff00a6ff),
                                        shape = CircleShape
                                    )
                                    .constrainAs(icon) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(parent.start)
                                    },
                                contentAlignment = Alignment.Center,
                                content = {
                                    val iconRes =
                                        if (isPlaying) R.drawable.outline_play_arrow_24 else R.drawable.rounded_pause_24
                                    Image(
                                        painter = painterResource(iconRes),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            )
                            Text(
                                modifier = Modifier
                                    .constrainAs(text) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(icon.end)
                                    }
                                    .padding(start = 20.dp,end = 95.dp).fillMaxWidth(),
                                text = audio.fileName,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Icon(
                                modifier = Modifier
                                    .constrainAs(endIcon) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(parent.end)
                                    }
                                    .size(30.dp),
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null
                            )
                        }
                    )
                }
            )
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    )
}

@Composable
fun AudioPlayerScreen(audioList: List<AudioEntity>) {
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Column {
        audioList.forEach { audio ->
            CardAudio(
                audio = audio,
                onPlayPauseClick = { filePath ->
                    mediaPlayer?.stop()
                    mediaPlayer?.release()

                    mediaPlayer = MediaPlayer().apply {
                        setDataSource(filePath)
                        prepare()
                        start()
                    }
                },
                isPlaying = false
            )
        }
    }
}

@Preview
@Composable
private fun CardAudioPrev() {
    val dummyAudio = listOf(
        AudioEntity(fileName = "Audio 1", filePath = "path_to_audio_1", dateTime = "2022"),
    )
    AudioPlayerScreen(audioList = dummyAudio)
}