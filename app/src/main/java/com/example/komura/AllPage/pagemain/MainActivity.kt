package com.example.komura.AllPage.pagemain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.pagemain.history.PageHistory
import com.example.komura.AllPage.pagemain.home.PageHome
import com.example.komura.AllPage.pagemain.setting.PageSetting
import com.example.komura.reuseableComponent.BottomBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var getRouteAppBar by remember {
                mutableStateOf("")
            }

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {},
                        colors = TopAppBarDefaults.topAppBarColors(
                            Color(0xffb8b8b8)
                        )
                    )
                },
                content = {
                    Column(
                        modifier = Modifier.padding(it),
                        content = {
                            NavHost(
                                navController = navController,
                                startDestination = "home",
                                builder = {
                                    composable("home") { PageHome() }
                                    composable("history") { PageHistory() }
                                    composable("setting") { PageSetting() }
                                }
                            )
                        }
                    )
                },

                bottomBar = {
                    BottomBar(
                        navController = navController,
                        getTopBar = { getRouteAppBar = it }
                    )
                },
            )
        }
    }
}