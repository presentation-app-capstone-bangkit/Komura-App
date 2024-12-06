package com.example.komura.AllPage.pagemain

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.pageSupport.ActivityAccount
import com.example.komura.AllPage.pagemain.all.PageHistoryAll
import com.example.komura.AllPage.pagemain.audioSpeech.AudioActivity
import com.example.komura.AllPage.pagemain.audioSpeech.PageAudioSpeech
import com.example.komura.AllPage.pagemain.learningPath.terminalPageLearningPage.PageTerminalLearningPath
import com.example.komura.AllPage.pagemain.vidioSpeech.PageVidioSpeech
import com.example.komura.R
import com.example.komura.reuseableComponent.DataNavButtonHistory
import com.example.komura.reuseableComponent.FabAddImg
import com.example.komura.reuseableComponent.NavigasiButtonHistory
import com.example.komura.room.VideoEntity
import com.example.komura.room.VideoViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            permissions.entries.forEach { (permission, isGranted) ->
                if (isGranted) {
                    Toast.makeText(this, "$permission diizinkan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "$permission ditolak", Toast.LENGTH_SHORT).show()
                }
            }
        }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            var search by remember { mutableStateOf("") }
            val createContext = LocalContext.current

            var videoFile by remember { mutableStateOf<File?>(null) }
            var showDialog by remember { mutableStateOf(false) }

            val recordVideoLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.CaptureVideo(),
                onResult = { success ->
                    if (success) {
                        showDialog = true
                    } else {
                        Toast.makeText(this, "Perekaman gagal", Toast.LENGTH_SHORT).show()
                    }
                }
            )

            val requiredPermissions = arrayOf(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.RECORD_AUDIO,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )

            val notGrantedPermissions = requiredPermissions.filter {
                checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED
            }

            if (notGrantedPermissions.isNotEmpty()) {
                requestPermissionsLauncher.launch(notGrantedPermissions.toTypedArray())
            }

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {},
                        navigationIcon = {
                            Text(
                                text = "Speechs",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(start = 10.dp),
                                color = Color.DarkGray,
                                letterSpacing = 1.sp
                            )
                        },
                        actions = {
                            IconButton(
                                modifier = Modifier
                                    .padding(end = 10.dp, top = 10.dp)
                                    .size(50.dp),
                                onClick = {
                                    val intent = Intent(createContext, ActivityAccount::class.java)
                                    createContext.startActivity(intent)
                                },
                                content = {
                                    Image(
                                        painter = painterResource(R.drawable.martin),
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            )
                        }
                    )
                },
                content = {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .padding(15.dp),
                    ) {
                        TextField(
                            value = search,
                            onValueChange = { newSearch ->
                                search = newSearch
                            },
                            placeholder = { Text(text = "Search Speech") },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions.Default,
                            singleLine = true,
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent,
                                containerColor = Color(0xffe6e6e6)
                            ),
                            modifier = Modifier
                                .width(400.dp),
                            shape = RoundedCornerShape(10.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            }
                        )
                        Spacer(modifier = Modifier.padding(5.dp))

                        NavigasiButtonHistory(navController = navController)

                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = DataNavButtonHistory.All.route,
                            ) {
                                composable(DataNavButtonHistory.All.route) { PageHistoryAll() }
                                composable(DataNavButtonHistory.Vidio.route) { PageVidioSpeech() }
                                composable(DataNavButtonHistory.Audio.route) { PageAudioSpeech() }
                                composable(DataNavButtonHistory.LearningPath.route) {
                                    PageTerminalLearningPath(navController = navController)
                                }
                            }
                        }
                    }
                },
                floatingActionButton = {
                    FabAddImg(
                        onVoiceClick = {
                            val intent = Intent(this, AudioActivity::class.java)
                            this.startActivity(intent)
                        },
                        onCameraClick = {
                            videoFile = createVideoFile()
                            val videoUri = videoFile?.getUri(context = this@MainActivity)
                            videoUri?.let { recordVideoLauncher.launch(it) }
                        }
                    )
                }
            )

            if (showDialog && videoFile != null) {
                ShowSaveDialog(
                    context = createContext,
                    videoFile = videoFile!!,
                    onDismiss = {
                        showDialog = false
                    },
                    onSave = {
                        videoFile?.renameTo(it)
                        Toast.makeText(createContext, "File disimpan", Toast.LENGTH_SHORT).show()
                        showDialog = false
                    }
                )
            }
        }
    }
}


private fun Context.createVideoFile(): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
//    val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
    val dir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)

    if (dir != null && !dir.exists()) {
        dir.mkdirs()
    }

    return File.createTempFile(
        "VIDEO_${timeStamp}_",
        ".mp4",
        dir
    )
}

private fun Context.addVideoToGallery(file: File) {
    val uri = Uri.fromFile(file)
    val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
    intent.data = uri
    sendBroadcast(intent)
}

private fun File.getUri(context: Context): Uri? {
    return FileProvider.getUriForFile(
        context,
        context.applicationContext.packageName + ".fileprovider",
        this
    )
}

@Composable
fun ShowSaveDialog(
    context: Context, videoFile: File, onSave: (File) -> Unit, onDismiss: () -> Unit
) {
    var videoName by remember { mutableStateOf("") }

    val videoViewModel: VideoViewModel = viewModel()

    AlertDialog(
        onDismissRequest = { },
        title = { Text("Apakah kamu ingin minyimpan vidionya?") },
        text = {
            Column {
                TextField(
                    value = videoName,
                    onValueChange = { videoName = it },
                    label = { Text("Masukkan nama file") },
                    singleLine = true
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val finalFileName = if (videoName.isEmpty()) {
                        "VIDEO_${
                            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(
                                Date()
                            )
                        }"
                    } else {
                        videoName
                    }

                    val updatedFile = File(videoFile.parent, finalFileName)

                    if (videoFile.renameTo(updatedFile)) {
                        val videoEntity = VideoEntity(
                            fileName = finalFileName,
                            filePath = updatedFile.absolutePath,
                            dateTime = SimpleDateFormat(
                                "yyyy-MM-dd HH:mm:ss",
                                Locale.getDefault()
                            ).format(Date())
                        )

                        videoViewModel.insertVideo(videoEntity)

                        context.addVideoToGallery(updatedFile)

                        onSave(updatedFile)
                        onDismiss()
                        Toast.makeText(context, "vido File disimpan ke galeri", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(context, "Gagal menyimpan vidio file", Toast.LENGTH_SHORT)
                            .show()
                    }
                    Log.e(
                        "FileRenameError",
                        "Failed to rename file: ${videoFile.absolutePath} to ${updatedFile.absolutePath}"
                    )
                }
            ) { Text("Ya") }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
                Toast.makeText(context, "File tidak disimpan", Toast.LENGTH_SHORT).show()
            }) { Text("Tidak") }
        }
    )
}

