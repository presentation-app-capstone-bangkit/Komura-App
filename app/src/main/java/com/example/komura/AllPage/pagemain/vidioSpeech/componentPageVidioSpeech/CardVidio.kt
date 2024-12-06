package com.example.komura.AllPage.pagemain.vidioSpeech.componentPageVidioSpeech

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.FileProvider
import com.example.komura.R
import com.example.komura.room.VideoEntity
import java.io.File

@Composable
fun CardVidio(vidio: VideoEntity) {
    val context = LocalContext.current
    val thumbnailBitmap = getVideoThumbnail(context, vidio.filePath)

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        val (text, endIcon) = createRefs()
                        Text(
                            modifier = Modifier.constrainAs(ref = text) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                            }.fillMaxWidth().padding(end = 40.dp),
                            text = vidio.fileName,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            modifier = Modifier
                                .constrainAs(ref = endIcon) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    end.linkTo(parent.end)
                                }
                                .size(30.dp),
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }
                }
            )
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xff00a6ff),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(200.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    content = {
                        thumbnailBitmap?.let {
                            Image(
                                bitmap = it.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xff00a6ff),
                            shape = CircleShape
                        )
                        .size(40.dp)
                        .clickable {
                            Uri
                                .parse(vidio.filePath)
                                .openVideoPlayer(context)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.outline_play_arrow_24),
                        contentDescription = null
                    )
                }
            }
        },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    )
}

@SuppressLint("QueryPermissionsNeeded")
fun Uri.openVideoPlayer(context: Context) {
    val file = this.path?.let { File(it) }
    val videoUri =
        file?.let { FileProvider.getUriForFile(context, "com.example.komura.fileprovider", it) }

    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(videoUri, "video/*")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }

    try {
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            Toast.makeText(
                context,
                "pemutar video yang mendukung format file tidak ada",
                Toast.LENGTH_LONG
            ).show()
        }
    } catch (e: Exception) {
        Toast.makeText(context, "No video player found", Toast.LENGTH_LONG).show()
    }
}

fun getVideoThumbnail(context: Context, filePath: String): Bitmap? {
    val retriever = MediaMetadataRetriever()
    return try {
        retriever.setDataSource(filePath)
        retriever.getFrameAtTime(1000)
    } catch (e: Exception) {
        null
    } finally {
        retriever.release()
    }
}

@Preview
@Composable
private fun CardVidioPrev() {
    val dummyVideo =
        VideoEntity(fileName = "Example Video", filePath = "path_to_video", dateTime = "2022")
    CardVidio(vidio = dummyVideo)
}