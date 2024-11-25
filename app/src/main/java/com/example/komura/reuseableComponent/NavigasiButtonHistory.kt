package com.example.komura.reuseableComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigasiButtonHistory(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val getNavigasiButtonHistory = listOf(
        DataNavButtonHistory.All,
        DataNavButtonHistory.Vidio,
        DataNavButtonHistory.Audio,
        DataNavButtonHistory.LearningPath
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(
                items = getNavigasiButtonHistory,
                itemContent = { item ->
                    val isSelected = navBackStackEntry?.destination?.route == item.route
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (isSelected) Color(0xff00a6ff) else Color.White,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color(0xff00a6ff),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .clickable {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        content = {
                            Text(
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                ),
                                text = item.title,
                                color = if (isSelected) Color.White else Color(0xFF00A6FF)
                            )
                        }
                    )
                }
            )
        }
    )
}

@Preview
@Composable
private fun NavigasiButtonHistoryPrev() {
    NavigasiButtonHistory(rememberNavController())
}