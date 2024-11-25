package com.example.komura.reuseableComponent

sealed class DataNavButtonHistory(
    val route: String,
    val title: String
){
    data object All: DataNavButtonHistory(
        route = "all",
        title = "All"
    )

    data object Audio: DataNavButtonHistory(
        route = "audio",
        title = "Audio Speech"
    )

    data object Vidio: DataNavButtonHistory(
        route = "vidio",
        title = "Vidio Speech"
    )

    data object LearningPath: DataNavButtonHistory(
        route = "Learning Path",
        title = "Learning Path"
    )
}