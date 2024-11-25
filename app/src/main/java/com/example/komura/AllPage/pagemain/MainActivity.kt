package com.example.komura.AllPage.pagemain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.pageSupport.ActivityAccount
import com.example.komura.AllPage.pagemain.all.PageHistoryAll
import com.example.komura.AllPage.pagemain.audioSpeech.PageAudioSpeech
import com.example.komura.AllPage.pagemain.learningPath.terminalPageLearningPage.PageTerminalLearningPath
import com.example.komura.AllPage.pagemain.vidioSpeech.PageVidioSpeech
import com.example.komura.R
import com.example.komura.reuseableComponent.DataNavButtonHistory
import com.example.komura.reuseableComponent.FabAddImg
import com.example.komura.reuseableComponent.NavigasiButtonHistory

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var search by remember { mutableStateOf("") }
            val createContext = LocalContext.current

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
                            Box(
                                modifier = Modifier
                                    .padding(end = 10.dp, top = 10.dp)
                                    .clickable(
                                        onClick = {
                                            val intent = Intent(createContext, ActivityAccount::class.java)
                                            createContext.startActivity(intent)

                                        },
                                    ),
                                content = {
                                    Image(
                                        painter = painterResource(R.drawable.martin),
                                        contentDescription = null,
                                        modifier = Modifier.size(50.dp)
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
                        content = {
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
                                modifier = Modifier.fillMaxSize(),
                                content = {
                                    NavHost(
                                        navController = navController,
                                        startDestination = DataNavButtonHistory.All.route,
                                        builder = {
                                            composable(DataNavButtonHistory.All.route) { PageHistoryAll() }
                                            composable(DataNavButtonHistory.Vidio.route) { PageVidioSpeech() }
                                            composable(DataNavButtonHistory.Audio.route) { PageAudioSpeech() }
                                            composable(DataNavButtonHistory.LearningPath.route) { PageTerminalLearningPath(navController = navController) }
//                                            composable("path1") { PageLearningPath1() }
//                                            composable("path2") { PageLearningPath2() }
//                                            composable("setting") { PageSetting() }
                                        }
                                    )
                                }
                            )
                        }
                    )
                },

                floatingActionButton = {
                    FabAddImg(
                        onVoiceClick = {},
                        onCameraClick = {},
                        navController = navController
                    )
                }
            )
        }
    }
}