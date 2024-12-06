package com.example.komura.AllPage.pagemain.vidioSpeech

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
fun PageVidioSpeech() {
//    var items by remember { mutableStateOf(0) }
    val videoViewModel : VideoViewModel = viewModel()
    val videoList by videoViewModel.allVideos.observeAsState(initial = emptyList())

    if (videoList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = {
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
                    text = "Clik on the button at the bottom to start\na new Vidio speech analysis",
                    textAlign = TextAlign.Center
                )
            }
        )
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            content = {
                items(
                    items = videoList,
                    itemContent = {
                        Spacer(modifier = Modifier.padding(5.dp))
                        CardVidio(
                            vidio = it
                        )
                    }
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PageVidioSpeechPrev() {
    PageVidioSpeech()
}