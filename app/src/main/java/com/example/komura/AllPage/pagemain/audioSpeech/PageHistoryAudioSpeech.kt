package com.example.komura.AllPage.pagemain.audioSpeech

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.komura.R

@Composable
fun PageAudioSpeech() {
    var items by remember { mutableStateOf(0) }

    if (items == 0) {
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
                    text = "Clik on the button at the bottom to start\na new Audio speech analysis",
                    textAlign = TextAlign.Center
                )
            }
        )
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            content = {

            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PageAudioSpeechPrev() {
    PageAudioSpeech()
}








