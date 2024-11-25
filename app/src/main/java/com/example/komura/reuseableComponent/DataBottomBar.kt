package com.example.komura.reuseableComponent

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DataBottomBar(
    val route: String,
    val icon: ImageVector,
    val title: String? = null
) {
    data object Home : DataBottomBar(
        route = "home",
        icon = Icons.Default.Home,
        title = "Home"
    )

    data object History: DataBottomBar(
        route = "history",
        icon = Icons.Default.FavoriteBorder,
        title = "histroy"
    )

    data object Settings: DataBottomBar(
        route = "setting",
        icon = Icons.Default.Settings,
        title = "setting"
    )
}

