package com.example.komura.reuseableComponent

import android.util.Log
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavController, getTopBar: (String) -> Unit) {
    val navBackEntry by navController.currentBackStackEntryAsState()
    val getBottomBar = listOf(
        DataBottomBar.Home,
        DataBottomBar.History,
        DataBottomBar.Settings
    )

    NavigationBar(
        modifier = Modifier.shadow(10.dp, ambientColor = Color(0xFF989898), spotColor = Color(
            0xFF919191
        )
        ),
        content = {
            getBottomBar.forEach(
                action = { navItem ->
                    val isSelected = navBackEntry?.destination?.hierarchy?.any { it.route == navItem.route } == true
                    NavigationBarItem(
                        modifier = Modifier.wrapContentHeight(),
                        selected = isSelected,
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        onClick = {
                            try {
                                getTopBar(navItem.route)
                                navController.navigate(navItem.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            } catch (e: Exception) {
                                Log.d("bottom bar","bjir lah $e")
                            }
                        },
//                        label = {
//                            navItem.title?.let { Text(text = it) }
//                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xff353535),
                            selectedTextColor = Color(0xFFEE299B),
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            indicatorColor = if (isSelected) Color(0xffb8b8b8) else Color(0xffb8b8b8)
                        )
                    )
                }
            )
        },
        containerColor = Color(0xffb8b8b8)
    )
}

@Preview
@Composable
private fun BottomBarPrev() {
    BottomBar(rememberNavController()) {}
}






