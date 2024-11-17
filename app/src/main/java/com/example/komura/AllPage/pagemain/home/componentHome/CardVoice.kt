package com.example.komura.AllPage.pagemain.home.componentHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.komura.R

@Composable
fun CardVoice() {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(210.dp),
        content = {
            Box(
                content = {
                    Text(text = "Voice", modifier = Modifier.padding(top = 20.dp, start = 15.dp))
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.voice),
                                contentDescription = null,
                                modifier = Modifier.size(70.dp)
                            )
                        }
                    )
                }
            )
        },
        colors = CardDefaults.cardColors(
            Color(0xffb8b8b8)
        )
    )
}

@Preview
@Composable
private fun CardVoicePrev() {
    CardVoice()
}