package com.example.komura.AllPage.pagemain.vidioSpeech.componentPageVidioSpeech

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.komura.R

@Composable
fun CardAudio() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        content = {
            Row(
                modifier = Modifier.padding(20.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            val (icon, text,endIcon) = createRefs()
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .background(
                                        color = Color(0xff00a6ff),
                                        shape = CircleShape
                                    ).constrainAs(
                                        ref = icon,
                                        constrainBlock = {
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                            start.linkTo(parent.start)
                                        }
                                    ),
                                contentAlignment = Alignment.Center,
                                content = {
                                    Image(
                                        painter = painterResource(R.drawable.rounded_pause_24),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            )
                            Text(
                                modifier = Modifier.constrainAs(
                                    ref = text,
                                    constrainBlock = {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(icon.end)
                                    }
                                ).padding(start = 20.dp),
                                text = "Recordings 17-11-2024 08:56",
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                modifier = Modifier.constrainAs(
                                    ref = endIcon,
                                    constrainBlock = {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(parent.end)
                                    }
                                ).size(30.dp),
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

@Preview
@Composable
private fun CardAudioPrev() {
    CardAudio()
}