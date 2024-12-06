package com.example.komura.AllPage.pagemain.audioSpeech

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.komura.AllPage.pagemain.audioSpeech.ui.theme.KomuraTheme
import com.example.komura.R
import com.example.komura.room.AudioEntity
import com.example.komura.room.VideoViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AudioActivity : ComponentActivity() {
    private var mediaRecorder: MediaRecorder? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                permissions.entries.forEach { (permission, isGranted) ->
                    if (!isGranted) {
                        Toast.makeText(this, "Permission $permission denied", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

        val context = this

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(arrayOf(Manifest.permission.RECORD_AUDIO))
        }

        setContent {
            var showDialog by remember { mutableStateOf(false) }
            var fileToSave by remember { mutableStateOf<File?>(null) }

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {  },
                        navigationIcon = {
                            IconButton(onClick = { finish() }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        }
                    )
                },
                content = { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        AudioRecorderScreen(
                            startRecording = {
                                mediaRecorder = startRecording(context) { file ->
                                    fileToSave = file
                                }
                            },
                            stopRecording = { onStop ->
                                stopRecording(mediaRecorder)
                                fileToSave?.let { onStop(it) }
                                showDialog = true
                            }
                        )
                    }
                }
            )

            if (showDialog) {
                fileToSave?.let { file ->
                    ShowSaveAudioDialog(
                        context = context,
                        audioFile = file,
                        onSave = { updatedFile ->
                            finish()
                        },
                        onDismiss = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun AudioRecorderScreen(
    startRecording: () -> Unit,
    stopRecording: (onStop: (File?) -> Unit) -> Unit
) {
    var isRecording by remember { mutableStateOf(false) }
    var timerSeconds by remember { mutableStateOf(0) }
    var fileToSave by remember { mutableStateOf<File?>(null) }

    LaunchedEffect(isRecording) {
        if (isRecording) {
            while (isRecording) {
                kotlinx.coroutines.delay(1000L)
                timerSeconds++
            }
        } else {
            timerSeconds = 0
        }
    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        content = {
            val (button, timer, glombangSuara) = createRefs()

            Text(
                text = String.format("%02d : %02d", timerSeconds / 60, timerSeconds % 60),
                modifier = Modifier.constrainAs(ref = timer) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
            )

            Image(
                painter = painterResource(R.drawable.gelombangsuara),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .constrainAs(ref = glombangSuara) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(button.top)
                    },
                contentScale = ContentScale.Crop
            )

            IconButton(
                modifier = Modifier
                    .padding(40.dp)
                    .size(90.dp)
                    .constrainAs(ref = button) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                onClick = {
                    if (isRecording) {
                        stopRecording { file ->
                            file?.let {
                                fileToSave = it
                            }
                        }
                    } else {
                        startRecording()
                    }
                    isRecording = !isRecording
                },
                content = {
                    Image(
                        painter = painterResource(if (isRecording) R.drawable.micon else R.drawable.micof),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            )
        }
    )
}

private fun createAudioFile(context: Context): File {
    val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val fileName = "Audio_$timestamp"
    return File(context.filesDir, fileName)
}

private fun startRecording(context: Context, onFileReady: (File) -> Unit): MediaRecorder {
    val outputFile = createAudioFile(context)
    val recorder = MediaRecorder().apply {
        setAudioSource(MediaRecorder.AudioSource.MIC)
        setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        setOutputFile(outputFile.absolutePath)
        prepare()
        start()
    }
    Toast.makeText(context, "Recording started", Toast.LENGTH_SHORT).show()
    onFileReady(outputFile)
    return recorder
}

private fun stopRecording(mediaRecorder: MediaRecorder?) {
    mediaRecorder?.stop()
    mediaRecorder?.release()
}

@Composable
fun ShowSaveAudioDialog(
    context: Context,
    audioFile: File,
    onSave: (File) -> Unit,
    onDismiss: () -> Unit
) {
    var audioName by remember { mutableStateOf("") }
    val viewModel: VideoViewModel = viewModel()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Simpan Audio") },
        text = {
            Column {
                TextField(
                    value = audioName,
                    onValueChange = { audioName = it },
                    label = { Text("Masukkan nama file") },
                    singleLine = true
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val finalFileName = if (audioName.isEmpty()) {
                        "Audio_${
                            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(
                                Date()
                            )
                        }"
                    } else {
                        "$audioName"
                    }

                    val updatedFile = File(audioFile.parent, finalFileName)

                    if (audioFile.renameTo(updatedFile)) {
                        val audioEntity = AudioEntity(
                            fileName = finalFileName,
                            filePath = updatedFile.absolutePath,
                            dateTime = SimpleDateFormat(
                                "yyyy-MM-dd HH:mm:ss",
                                Locale.getDefault()
                            ).format(Date())
                        )
                        viewModel.insertAudio(audioEntity)

                        Toast.makeText(context, "audio File disimpan", Toast.LENGTH_SHORT).show()
                        onSave(updatedFile)
                    } else {
                        Toast.makeText(context, "Gagal menyimpan audio file", Toast.LENGTH_SHORT).show()
                    }
                }
            ) { Text("Simpan") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Batal")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AudioRecorderScreenPreview() {
    KomuraTheme {
        AudioRecorderScreen(
            startRecording = {  },
            stopRecording = {  }
        )
    }
}





