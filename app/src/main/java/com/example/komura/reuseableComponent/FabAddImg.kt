package com.example.komura.reuseableComponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.komura.R

@Composable
fun FabAddImg(
    onCameraClick: () -> Unit,
    onVoiceClick: () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(if (expanded) 45f else 0f)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd,
        content = {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    AnimatedVisibility(
                        visible = expanded,
                        enter = slideInVertically(
                            initialOffsetY = { it },
                            animationSpec = tween(durationMillis = 300)
                        ),
                        exit = slideOutVertically(
                            targetOffsetY = { it },
                            animationSpec = tween(durationMillis = 300)
                        ),
                        content = {
                            IconButton(
                                onClick = {
                                    onVoiceClick()
                                    expanded = false
                                },
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xff00a6ff))
                                    .zIndex(if (expanded) 1f else 0f),
                                content = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.takeaudio),
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            )
                        }
                    )

                    AnimatedVisibility(
                        visible = expanded,
                        enter = slideInVertically(
                            initialOffsetY = { it },
                            animationSpec = tween(durationMillis = 300, delayMillis = 50)
                        ),
                        exit = fadeOut() + shrinkOut(),
                        content = {
                            IconButton(
                                onClick = {
                                    onCameraClick()
                                    expanded = false
                                },
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xff00a6ff))
                                    .zIndex(if (expanded) 1f else 0f),
                                content = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.takevidio),
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            )
                        }
                    )

                    FloatingActionButton(
                        onClick = { expanded = !expanded },
                        modifier = Modifier
                            .graphicsLayer(rotationZ = rotationAngle)
                            .zIndex(1f),
                        shape = CircleShape,
                        containerColor = Color(0xff00a6ff),
                        contentColor = Color.White,
                        content = {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    )
                }
            )
        }
    )
}